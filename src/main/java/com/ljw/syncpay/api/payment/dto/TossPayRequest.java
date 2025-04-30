package com.ljw.syncpay.api.payment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class TossPayRequest {

    private final int amount;
    private final String orderId;
    private final String paymentKey;
    private final long userId;

}
