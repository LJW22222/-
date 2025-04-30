package com.ljw.syncpay.application.payment.port;

import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;

public interface PaymentUseCasePort {

    TossPaymentConfirmReponse tossPayment(String paymentKey, String orderId, int amount, long userId, int coupon);
    KaKaoPaymentConfirmReponse kakaoPayment(KaKaoPaymentInfo kaKaoPaymentInfo, long userId, int coupon);
    KaKaoPaymentSetResponse kakaoSetPayment(KaKaoPaymentSetInfo kaKaoPaymentSetInfo);

}
