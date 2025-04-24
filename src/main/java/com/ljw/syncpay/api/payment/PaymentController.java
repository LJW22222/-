package com.ljw.syncpay.api.payment;

import com.ljw.syncpay.api.payment.dto.TossPayRequest;
import com.ljw.syncpay.application.toss.port.TossUseCasePort;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
@CrossOrigin(origins = "http://localhost:4242")
@Slf4j
public class PaymentController {

    private final TossUseCasePort tossUseCasePort;

    @PostMapping("/tosspayment")
    public TossPaymentConfirmReponse getTossUseCasePort(
            @RequestBody TossPayRequest tossPayRequest
    ) {
        log.info("요청 들어옴 :: " + tossPayRequest.toString());
        return tossUseCasePort.tossPayment(
                tossPayRequest.getPaymentKey(),
                tossPayRequest.getOrderId(),
                tossPayRequest.getAmount(),
                tossPayRequest.getUserId(),
                tossPayRequest.getCoupon()
        );
    }
}
