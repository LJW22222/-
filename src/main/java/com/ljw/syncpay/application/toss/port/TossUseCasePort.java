package com.ljw.syncpay.application.toss.port;

import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;

public interface TossUseCasePort {

    TossPaymentConfirmReponse tossPayment(String paymentKey, String orderId, int amount, long userId, int coupon);

}
