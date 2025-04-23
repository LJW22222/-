package com.ljw.syncpay.infra.toss.client;

import com.ljw.syncpay.infra.toss.config.TossOpenApiInterceptor;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "seoulBusOpenApi",
        url = "https://api.tosspayments.com/v1/payments/confirm",
        configuration = TossOpenApiInterceptor.class
)
public interface TossOpenApiClient {

    @GetMapping()
    TossPaymentConfirmReponse tossPayment(
            @RequestBody TossPaymentConfirmRequest request
    );
}
