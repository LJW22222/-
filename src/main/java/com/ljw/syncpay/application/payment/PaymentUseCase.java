package com.ljw.syncpay.application.payment;

import com.ljw.syncpay.application.payment.port.PaymentUseCasePort;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import com.ljw.syncpay.domain.payment.port.KaKaoOpenApiPort;
import com.ljw.syncpay.domain.payment.port.TossOpenApiPort;
import com.ljw.syncpay.domain.user.port.UserCommandPort;
import com.ljw.syncpay.domain.user.support.CouponDiscount;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentUseCase implements PaymentUseCasePort {

    private final TossOpenApiPort tossOpenApiPort;
    private final KaKaoOpenApiPort kaKaoOpenApiPort;
    private final UserCommandPort userCommandPort;

    /**
     * 토스 페이먼츠 결제 할인율의 경우, 프론트(React 기준)에서 결제 준비를 하고 값을 보내는데,
     * 할인율을 백엔드에서 적용하고 결제 승인을 보내면 결제 준비 값과, 결제 승인 값이 달라 에러가 발생하게 됨
     * 그러므로, 할인율 결제를 프론트에서 적용하고 금액을 보내는 방식으로 결정
     * 할인율 로직 같은 경우 CouponDiscount에 존재
     */
    @Override
    public TossPaymentConfirmReponse tossPayment(String paymentKey, String orderId, int amount, long userId) {
        TossPaymentConfirmReponse tossPaymentConfirmReponse = tossOpenApiPort.tossPayment(amount, paymentKey, orderId);
        log.info("tossPaymentConfirmReponse :: " + tossPaymentConfirmReponse.toString());
        userCommandPort.updateUserPoint(userId, tossPaymentConfirmReponse.getAmount());
        return tossPaymentConfirmReponse;
    }

    /**
     * KaKao의 경우, 결제 준비, 결제 승인을 백엔드에서 처리하고 URL만 리턴해주기 때문에
     * 별도로 백엔드에서 할인율을 계산할 수 있었음.
     */
    @Override
    public KaKaoPaymentConfirmReponse kakaoPayment(KaKaoPaymentInfo kaKaoPaymentInfo, long userId
    ) {
        log.info("kaKaoPaymentInfo :: " + kaKaoPaymentInfo);
        KaKaoPaymentConfirmReponse kaKaoPaymentConfirmReponse = kaKaoOpenApiPort.kakaoPayment(kaKaoPaymentInfo);
        log.info("kaKaoPaymentConfirmReponse22 :: " + kaKaoPaymentConfirmReponse.toString());
        userCommandPort.updateUserPoint(userId, kaKaoPaymentConfirmReponse.getAmount().getTotal());
        return kaKaoPaymentConfirmReponse;
    }

    @Override
    public KaKaoPaymentSetResponse kakaoSetPayment(KaKaoPaymentSetInfo kaKaoPaymentInfo) {
        int totalAmount = kaKaoPaymentInfo.getTotalAmount();
        int discount = CouponDiscount.discount(kaKaoPaymentInfo.getCoupo(), totalAmount);
        int discountAmount = totalAmount - discount;
        kaKaoPaymentInfo.updateTotalCount(discountAmount);
        KaKaoPaymentSetResponse kaKaoPaymentSetResponse = kaKaoOpenApiPort.kakaoSetPayment(kaKaoPaymentInfo);
        kaKaoPaymentSetResponse.updateTotalAmount(discountAmount);
        log.info("kaKaoPaymentSetResponse :: " + kaKaoPaymentSetResponse);
        return kaKaoPaymentSetResponse;
    }
}
