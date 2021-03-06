package ru.crystals.pos.emsr.poslab;

import org.apache.commons.lang.StringUtils;
import ru.crystals.pos.emsr.ExternalMSRPluginImpl;
import ru.crystals.pos.keyboard.TrackProcessor;

import java.util.ArrayList;
import java.util.List;

public class PoslabMsrServiceImpl extends ExternalMSRPluginImpl {

    private static final String PROVIDER = "poslab";

    private List<Integer> cardPrefix1;

    private List<Integer> cardSuffix1;

    private List<Integer> cardPrefix2;

    private List<Integer> cardSuffix2;

    private List<Integer> cardPrefix3;

    private List<Integer> cardSuffix3;

    public PoslabMsrServiceImpl() {
        super(PROVIDER);
    }

    public PoslabMsrServiceImpl(TrackProcessor trackProcessor) {
        super(PROVIDER, trackProcessor);
    }

    @Override
    public List<Integer> getCardPrefix1() {
        if (cardPrefix1 == null) {
            cardPrefix1 = new ArrayList<>();
            cardPrefix1.add(37);
        }
        return cardPrefix1;
    }

    @Override
    public List<Integer> getCardSuffix1() {
        if (cardSuffix1 == null) {
            cardSuffix1 = new ArrayList<>();
            cardSuffix1.add(63);
        }
        return cardSuffix1;
    }

    @Override
    public List<Integer> getCardPrefix2() {
        if (cardPrefix2 == null) {
            cardPrefix2 = new ArrayList<>();
            cardPrefix2.add(59);
        }
        return cardPrefix2;
    }

    @Override
    public List<Integer> getCardSuffix2() {
        if (cardSuffix2 == null) {
            cardSuffix2 = new ArrayList<>();
            cardSuffix2.add(63);
        }
        return cardSuffix2;
    }

    @Override
    public List<Integer> getCardPrefix3() {
        if (cardPrefix3 == null) {
            cardPrefix3 = new ArrayList<>();
            cardPrefix3.add(59);
        }
        return cardPrefix3;
    }

    @Override
    public List<Integer> getCardSuffix3() {
        if (cardSuffix3 == null) {
            cardSuffix3 = new ArrayList<>();
            cardSuffix3.add(63);
        }
        return cardSuffix3;
    }

    @Override
    public String[] getTracks(List<Integer> scanCodeList) {

        if (scanCodeList == null || scanCodeList.isEmpty()) {
            return new String[4];
        }

        String[] rawTracks = getRawTracks(scanCodeList);
        String[] result = new String[Math.max(rawTracks.length, 4)];
        for (int i = 0; i < rawTracks.length; i++) {
            String track = rawTracks[i];
            if (StringUtils.isEmpty(track)) {
                track = null;
            } else {
                // ?????????????????? ???????????? ??????????????????????
                track = track.substring(0, track.length() - 1);
            }
            result[i] = track;
        }
        return result;
    }

    private String[] getRawTracks(List<Integer> scanCodeList) {
        return getRawTracks(scanCodeList, this);
    }
}
