package com.ljw.syncpay.infra.toss.client;

import com.ljw.syncpay.infra.toss.config.TossOpenApiInterceptor;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "tossOpenApi",
        url = "https://api.tosspayments.com",
        configuration = TossOpenApiInterceptor.class
)
public interface TossOpenApiClient {

    @PostMapping("/v1/payments/confirm")
    TossPaymentConfirmReponse tossPayment(
            @RequestBody TossPaymentConfirmRequest request
    );
}
