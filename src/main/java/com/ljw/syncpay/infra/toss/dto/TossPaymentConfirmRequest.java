package com.ljw.syncpay.infra.toss.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TossPaymentConfirmRequest {

    private final int amount;
    private final String orderId;
    private final String paymentKey;

}
