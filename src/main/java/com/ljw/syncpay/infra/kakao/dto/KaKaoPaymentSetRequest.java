package com.ljw.syncpay.infra.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentInfo;
import com.ljw.syncpay.domain.payment.dto.KaKaoPaymentSetInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class KaKaoPaymentSetRequest {

    private final String cid;
    private final String partner_order_id;
    private final String partner_user_id;
    private final String item_name;
    private final Integer quantity;
    private final Integer tax_free_amount = 0;
    private final Integer total_amount;
    private final String approval_url;
    private final String cancel_url;
    private final String fail_url;


    public KaKaoPaymentSetRequest(KaKaoPaymentSetInfo kaKaoPaymentInfo) {
        this.cid = kaKaoPaymentInfo.getCid();
        this.partner_order_id = kaKaoPaymentInfo.getPartnerOrderId();
        this.partner_user_id = kaKaoPaymentInfo.getPartnerUserId();
        this.item_name = kaKaoPaymentInfo.getItemName() ;
        this.quantity = kaKaoPaymentInfo.getQuantity();
        this.total_amount = kaKaoPaymentInfo.getTotalAmount();
        this.approval_url = kaKaoPaymentInfo.getApprovalUrl();
        this.cancel_url = kaKaoPaymentInfo.getCancelUrl();
        this.fail_url = kaKaoPaymentInfo.getFailUrl();
    }
}
