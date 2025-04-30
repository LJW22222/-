package com.ljw.syncpay.infra.kakao.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class KaKaoPaymentConfirmRequest {

    @JsonProperty("cid")
    private final String cid;

    @JsonProperty("tid")
    private final String tid;

    @JsonProperty("partner_order_id")
    private final String partnerOrderId;

    @JsonProperty("partner_user_id")
    private final String partnerUserId;

    @JsonProperty("pg_token")
    private final String pgToken;

    @JsonProperty("total_amount")
    private final int totalAmount;

    public KaKaoPaymentConfirmRequest(KaKaoPaymentInfo kaKaoPaymentInfo) {
        this.cid = kaKaoPaymentInfo.cid();
        this.tid = kaKaoPaymentInfo.tid();
        this.partnerOrderId = kaKaoPaymentInfo.partner_order_id();
        this.partnerUserId = kaKaoPaymentInfo.partner_user_id();
        this.pgToken = kaKaoPaymentInfo.pg_token();
        this.totalAmount = kaKaoPaymentInfo.total_amount();
    }
}
