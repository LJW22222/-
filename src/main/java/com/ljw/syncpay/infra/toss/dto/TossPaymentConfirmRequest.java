package com.ljw.syncpay.infra.toss.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class TossPaymentConfirmRequest {

    private String paymentKey;
    private String orderId;
    private int amount;

    public TossPaymentConfirmRequest(String paymentKey, String orderId, int amount) {
        this.paymentKey = paymentKey;
        this.orderId = orderId;
        this.amount = amount;
    }
}
