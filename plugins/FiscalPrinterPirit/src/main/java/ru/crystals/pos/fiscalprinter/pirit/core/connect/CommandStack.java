package ru.crystals.pos.fiscalprinter.pirit.core.connect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.crystals.pos.fiscalprinter.exception.FiscalPrinterCommunicationException;
import ru.crystals.pos.fiscalprinter.exception.FiscalPrinterException;

/**
 * Created by v.paydulov on 14.03.2017.
 */
public class CommandStack {

    private static final Logger log = LoggerFactory.getLogger(PiritConnector.class);

    class RequestResponse {

        private PiritRequestPacket requestPacket;
        private PiritResponsePacket responsePacket;

        public RequestResponse(PiritRequestPacket requestPacket) {
            this.requestPacket = requestPacket;
        }

        public PiritRequestPacket getRequestPacket() {
            return requestPacket;
        }

        public PiritResponsePacket getResponsePacket() {
            return responsePacket;
        }

        public void setResponsePacket(PiritResponsePacket responsePacket) {
            this.responsePacket = responsePacket;
        }
    }

    private static final int QUEUE_SIZE = 208;
    private int stackSize;
    private BlockingQueue<PiritRequestPacket> stack = new LinkedBlockingQueue<>();
    private Map<PacketId, RequestResponse> responsesOtherThreadId = new ConcurrentHashMap<>();

    public CommandStack() {
        this(QUEUE_SIZE);
    }

    public CommandStack(int queueSize) {
        stackSize = queueSize;
    }

    public void markRequestAsLost(PacketId packetId) {
        RequestResponse rr = responsesOtherThreadId.get(packetId);
        if (rr != null) {
            rr.getRequestPacket().setLost();
        }
    }

    public int getStackSize() {
        return stack.size();
    }

    List<PiritRequestPacket> getStackBody() {
        return Arrays.asList(stack.toArray(new PiritRequestPacket[0]));
    }

    protected long getCurrentThreadID() {
        return Thread.currentThread().getId();
    }

    public void addRequestPacket(PiritRequestPacket packet) throws FiscalPrinterException {
        try {
            packet.setThreadID(getCurrentThreadID());
            stack.put(packet);
            RequestResponse requestResponse = new RequestResponse(packet);
            responsesOtherThreadId.put(packet.getPacketId(), requestResponse);
            if (stack.size() > stackSize) {
                PiritRequestPacket packetToRemove = stack.take();
            }
        } catch (InterruptedException e) {
            throw new FiscalPrinterException("", e);
        }
    }

    public PiritResponsePacket getResponsePacketBeforeRead(PacketId packetId) throws FiscalPrinterCommunicationException {
        RequestResponse requestResponsePair = responsesOtherThreadId.get(packetId);
        if (requestResponsePair != null) {
            if (requestResponsePair.getRequestPacket().isLost()) {
                log.error("Skip lost response: " + requestResponsePair.getResponsePacket());
            } else {
                PiritResponsePacket response = requestResponsePair.getResponsePacket();
                if (response != null) {
                    responsesOtherThreadId.remove(response.getPacketId());
                    validateAnswer(response);
                    return response;
                }
            }
        }
        return null;
    }

    public PiritResponsePacket getResponsePacket(PiritResponsePacket responsePacket, PacketId requestPacketId) throws FiscalPrinterException {
        RequestResponse requestResponsePair = responsesOtherThreadId.get(responsePacket.getPacketId());
        if (requestResponsePair != null && requestResponsePair.getRequestPacket() != null && requestResponsePair.getRequestPacket().isLost()) {
            // ?????????? ?????? ???????? ?????????????? ?????? ?????????? ???? ???????? - timeout
            requestResponsePair.setResponsePacket(responsePacket);
            log.error("Skip lost response: {}", responsePacket);
            return null;
        }

        requestResponsePair = responsesOtherThreadId.get(requestPacketId);
        if (requestResponsePair != null) {// ?????????????????????????? ????????????????
            responsesOtherThreadId.remove(requestPacketId);
        } else {// ???????????????? ?????????? ?????????????? ????????????
            RequestResponse oldErrorRequestPacket = responsesOtherThreadId.get(responsePacket.getPacketId());
            if (oldErrorRequestPacket != null) {
                if (oldErrorRequestPacket.getRequestPacket().getThreadID() != getCurrentThreadID()) {// ???? - ???????????? ??????????
                    oldErrorRequestPacket.setResponsePacket(responsePacket);// ?????????????? ??????
                    responsePacket = null;
                }//else  ?????????????? ?????? ?? ????????????
            } else {// ???????? ???????????????? ?????????? ?????????????? ?????????? ???? ?????????????????? - ?????????????? ??????, ???????????? ???????????????????? ????????????
                responsePacket = null;
            }
        }
        validateAnswer(responsePacket);
        return responsePacket;
    }

    private void validateAnswer(PiritResponsePacket responsePacket) throws FiscalPrinterCommunicationException {
        if (responsePacket == null || responsePacket.getErrorCode() == 0) {
            return;
        }
        int errorCode = responsePacket.getErrorCode();
        final String errorMessage = PiritErrorMsg.getErrorMessage(errorCode);
        log.error("Error received! Error code={}(0x{}), error message={}", errorCode, String.format("%02X", errorCode), errorMessage);
        throw new FiscalPrinterCommunicationException(errorMessage, PiritErrorMsg.getErrorType(errorCode), errorCode);
    }

}
