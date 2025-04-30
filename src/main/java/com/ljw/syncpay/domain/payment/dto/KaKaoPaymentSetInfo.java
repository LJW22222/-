package com.ljw.syncpay.domain.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class KaKaoPaymentSetInfo{
    private final String cid;
    private final String partnerOrderId;
    private final String partnerUserId;
    private final String itemName;
    private final Integer quantity;
    private Integer totalAmount;
    private final String approvalUrl;
    private final String cancelUrl;
    private final String failUrl;
    private final Integer coupo;


    public void updateTotalCount(int discountAmount) {
        this.totalAmount = discountAmount;
    }

}
