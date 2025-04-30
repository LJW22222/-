package com.ljw.syncpay.infra.adapter;

import com.ljw.syncpay.domain.payment.port.TossOpenApiPort;
import com.ljw.syncpay.infra.toss.client.TossOpenApiClient;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TossPaymentAdapter implements TossOpenApiPort {

    private final TossOpenApiClient tossOpenApiClient;

    @Override
    public TossPaymentConfirmReponse tossPayment(int amount, String paymentKey, String orderId) {
        TossPaymentConfirmRequest tossPaymentConfirmRequest = new TossPaymentConfirmRequest(paymentKey, orderId, amount);
        log.info("tossPaymentConfirmRequest :: " + tossPaymentConfirmRequest.toString());
        return tossOpenApiClient.tossPayment(tossPaymentConfirmRequest);
    }
}
