package com.ljw.syncpay.api.payment;

import com.ljw.syncpay.api.payment.dto.KaKaoPayRequest;
import com.ljw.syncpay.api.payment.dto.KakaoReadyRequest;
import com.ljw.syncpay.api.payment.dto.TossPayRequest;
import com.ljw.syncpay.application.payment.port.PaymentUseCasePort;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentConfirmReponse;
import com.ljw.syncpay.infra.kakao.dto.KaKaoPaymentSetResponse;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
@Slf4j
public class PaymentController {

    private final PaymentUseCasePort paymentUseCasePort;


    /**
     * 결제 요청 API를 통해 결제, 포인트 적립을 수행한다.
     * 포인트 할인율이 적용되서 들어오면, 해당 할인율을 적용한 금액을 결제, 포인트 적립을 수행한다.
     * @param tossPayRequest
     * @return
     */
    @PostMapping("/tosspayment")
    public TossPaymentConfirmReponse tossPayment(
            @RequestBody TossPayRequest tossPayRequest
    ) {
        log.info("Toss pay 요청 들어옴 :: " + tossPayRequest.toString());
        return paymentUseCasePort.tossPayment(
                tossPayRequest.getPaymentKey(),
                tossPayRequest.getOrderId(),
                tossPayRequest.getAmount(),
                tossPayRequest.getUserId()
        );
    }

    /**
     * 카카오 결제 승인을 한다.
     * 들어오는 결제 금액은 결제 준비단계에서 discount하고 들어온 값이다.
     * @param kaKaoPayRequest
     * @return
     */
    @PostMapping("/kakapayment")
    public KaKaoPaymentConfirmReponse naverPayment(
            @RequestBody KaKaoPayRequest kaKaoPayRequest
    ) {
        log.info("Kakao pay 요청 들어옴 :: " + kaKaoPayRequest.toString());
        KaKaoPaymentConfirmReponse kaKaoPaymentConfirmReponse = paymentUseCasePort.kakaoPayment(
                new KaKaoPaymentInfo(
                        kaKaoPayRequest.getCid(),
                        kaKaoPayRequest.getTid(),
                        kaKaoPayRequest.getPartner_order_id(),
                        kaKaoPayRequest.getPartner_user_id(),
                        kaKaoPayRequest.getPg_token(),
                        kaKaoPayRequest.getTotal_amount()
                ),
                kaKaoPayRequest.getUserId()
        );
        log.info(kaKaoPaymentConfirmReponse.toString());
        return kaKaoPaymentConfirmReponse;
    }


    /**
     * 카카오 결제 준비를 하여 결제창을 retrun한다.
     * 카카오의 경우 결제 준비, 승인을 백엔드를 통해 처리를 한다.
     * amount같은 경우, 할인율이 들어오면 discount한 값을 최종적으로 결제 준비 body에 담아서 보낸다.
     * @param request
     * @return
     */
    @PostMapping("/kakaopay/ready")
    public KaKaoPaymentSetResponse kakaoPayReady(@RequestBody KakaoReadyRequest request) {
        KaKaoPaymentSetResponse kaKaoPaymentSetResponse = paymentUseCasePort.kakaoSetPayment(new KaKaoPaymentSetInfo(
                request.getCid(),
                request.getPartnerOrderId(),
                request.getPartnerUserId(),
                request.getItemName(),
                request.getQuantity(),
                request.getTotalAmount(),
                request.getApprovalUrl(),
                request.getCancelUrl(),
                request.getFailUrl(),
                request.getCoupon()
        ));
        log.info(kaKaoPaymentSetResponse.toString());
        return kaKaoPaymentSetResponse;
    }
}
