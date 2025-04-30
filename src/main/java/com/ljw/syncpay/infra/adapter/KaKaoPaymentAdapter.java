package com.ljw.syncpay.infra.adapter;

import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import com.ljw.syncpay.domain.payment.port.KaKaoOpenApiPort;
import com.ljw.syncpay.infra.kakao.client.KaKaoOpenApiClient;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmRequest;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetRequest;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KaKaoPaymentAdapter implements KaKaoOpenApiPort {

    private final KaKaoOpenApiClient kaKaoOpenApiClient;


    @Override
    public KaKaoPaymentConfirmReponse kakaoPayment(KaKaoPaymentInfo kaKaoPaymentInfo) {
        KaKaoPaymentConfirmRequest request = new KaKaoPaymentConfirmRequest(kaKaoPaymentInfo);
        log.info("kaKaoPaymentConfirmRequest :: {}", request);

        try {
            KaKaoPaymentConfirmReponse response = kaKaoOpenApiClient.kakaoPayment(request);
            log.info("kaKaoPaymentConfirmReponse :: {}", response);
            return response;
        } catch (Exception e) {
            log.error("KakaoPay approve API 실패", e);
            throw e;
        }
    }

    @Override
    public KaKaoPaymentSetResponse kakaoSetPayment(KaKaoPaymentSetInfo kaKaoPaymentInfo) {
        KaKaoPaymentSetRequest kaKaoPaymentSetRequest = new KaKaoPaymentSetRequest(kaKaoPaymentInfo);
        log.info("kaKaoPaymentSetRequest :: {}", kaKaoPaymentSetRequest);
        return kaKaoOpenApiClient.kakaoPaymentSet(kaKaoPaymentSetRequest);
    }
}
