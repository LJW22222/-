package com.ljw.syncpay.domain.toss.port;

import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;

public interface TossOpenApiPort {

    TossPaymentConfirmReponse tossPayment(int amount, String paymentKey, String orderId);

}
