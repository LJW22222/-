package com.ljw.syncpay.api.point.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TossPayRequest {

    private final int amount;
    private final String orderId;
    private final String paymentKey;
    private final long userId;
    private final int coupon;

}
