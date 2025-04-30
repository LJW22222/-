package com.ljw.syncpay.domain.payment.dto;

public record KaKaoPaymentInfo(
        String cid,
        String tid,
        String partner_order_id,
        String partner_user_id,
        String pg_token,
        int total_amount
) {
}
