package ru.crystals.pos.bank.raiffeisensbp.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Тип QR кода
 */
public enum QRType {


    /**
     * Динамический QR-код.
     * Может быть оплачен только один раз.
     * Сумма оплаты фиксированная, передается в момент регистрации QR-кода, клиент не может ее изменить.
     * Подходит для интернет-магазинов и онлайн-сервисов.
     */
    @JsonProperty("QRDynamic")
    QR_DYNAMIC,

    /**
     * статический QR-код. Может быть оплачен несколько раз.
     * Если будет зарегистрирован статический QR-код без суммы - клиент самостоятельно укажет сумму в мобильном приложении.
     * Подходит для размещения на кассе и благотворительных фондов.
     * Не используется
     */
    @JsonProperty("QRStatic")
    QR_STATIC

}
