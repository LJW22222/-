package com.ljw.syncpay.infra.adapter;

import com.ljw.syncpay.domain.toss.port.TossOpenApiPort;
import com.ljw.syncpay.infra.toss.client.TossOpenApiClient;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TossPaymentAdapter implements TossOpenApiPort {

    private final TossOpenApiClient tossOpenApiClient;

    @Override
    public TossPaymentConfirmReponse tossPayment(int amount, String paymentKey, String orderId) {
        return tossOpenApiClient.tossPayment(new TossPaymentConfirmRequest(amount,orderId,paymentKey));
    }
}
