package com.ljw.syncpay.application.toss;

import com.ljw.syncpay.application.toss.port.TossUseCasePort;
import com.ljw.syncpay.domain.toss.port.TossOpenApiPort;
import com.ljw.syncpay.domain.user.port.UserCommandPort;
import com.ljw.syncpay.domain.user.support.CouponDiscount;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TossUseCase implements TossUseCasePort {

    private final TossOpenApiPort tossOpenApiPort;
    private final UserCommandPort userCommandPort;

    @Override
    public TossPaymentConfirmReponse tossPayment(String paymentKey, String orderId, int amount, long userId, int coupon) {
        int discount = CouponDiscount.discount(coupon, amount);
        int discountAmount = amount - discount;
//            TossPaymentConfirmReponse tossPaymentConfirmReponse = tossOpenApiPort.tossPayment(discountAmount, paymentKey, orderId);

//        userCommandPort.updateUserPoint(userId, tossPaymentConfirmReponse.getAmount());
        userCommandPort.updateUserPoint(userId, discountAmount);
//        return tossPaymentConfirmReponse;
        return null;
    }
}
