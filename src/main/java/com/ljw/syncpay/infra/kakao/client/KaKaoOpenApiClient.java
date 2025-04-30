package com.ljw.syncpay.infra.kakao.client;

import com.ljw.syncpay.infra.kakao.config.KaKaoOpenApiInterceptor;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmRequest;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetRequest;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "kakaoOpenApi",
        url = "https://open-api.kakaopay.com",
        configuration = KaKaoOpenApiInterceptor.class
)
public interface KaKaoOpenApiClient {

    @PostMapping("/online/v1/payment/approve")
    KaKaoPaymentConfirmReponse kakaoPayment(
            @RequestBody KaKaoPaymentConfirmRequest request
    );

    @PostMapping("/online/v1/payment/ready")
    KaKaoPaymentSetResponse kakaoPaymentSet(
            @RequestBody KaKaoPaymentSetRequest request
    );
}
