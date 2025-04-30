package com.ljw.syncpay.api.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class KakaoReadyRequest {
    private final String cid;
    private final String partnerOrderId;
    private final String partnerUserId;
    private final String itemName;
    private final Integer quantity;
    private final Integer totalAmount;
    private final Integer vatAmount;
    private final Integer taxFreeAmount;
    private final String approvalUrl;
    private final String cancelUrl;
    private final String failUrl;
    private final int coupon;
}
