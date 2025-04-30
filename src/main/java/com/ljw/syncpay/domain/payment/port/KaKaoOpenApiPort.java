package com.ljw.syncpay.domain.payment.port;

import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;

public interface KaKaoOpenApiPort {

    KaKaoPaymentConfirmReponse kakaoPayment(KaKaoPaymentInfo kaKaoPaymentInfo);
    KaKaoPaymentSetResponse kakaoSetPayment(KaKaoPaymentSetInfo kaKaoPaymentInfo);

}
