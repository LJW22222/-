package com.ljw.syncpay.api.point;

import com.ljw.syncpay.api.point.dto.TossPayRequest;
import com.ljw.syncpay.application.toss.port.TossUseCasePort;
import com.ljw.syncpay.infra.toss.dto.TossPaymentConfirmReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
public class PointController {

    private final TossUseCasePort tossUseCasePort;

    @PostMapping("/tosspayment")
    public TossPaymentConfirmReponse getTossUseCasePort(
            @RequestBody TossPayRequest tossPayRequest
    ) {
        return tossUseCasePort.tossPayment(
                tossPayRequest.getPaymentKey(),
                tossPayRequest.getOrderId(),
                tossPayRequest.getAmount(),
                tossPayRequest.getUserId(),
                tossPayRequest.getCoupon()
        );
    }
}
