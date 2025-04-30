package com.ljw.syncpay.api.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class KaKaoPayRequest {

    @JsonProperty("cid")
    private final String cid;
    @JsonProperty("tid")
    private final String tid;
    @JsonProperty("partnerOrderId")
    private final String partner_order_id;
    @JsonProperty("partnerUserId")
    private final String partner_user_id;
    @JsonProperty("pg_token")
    private final String pg_token;
    @JsonProperty("userId")
    private final long userId;
    @JsonProperty("coupon")
    private final int coupon;
    @JsonProperty("total_amount")
    private final int total_amount;

}
