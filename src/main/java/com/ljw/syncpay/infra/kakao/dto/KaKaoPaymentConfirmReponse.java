package com.ljw.syncpay.infra.kakao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KaKaoPaymentConfirmReponse {

    private String aid;
    private String tid;
    private String cid;
    private String sid;

    @JsonProperty("partner_order_id")
    private String partnerOrderId;

    @JsonProperty("partner_user_id")
    private String partnerUserId;

    @JsonProperty("payment_method_type")
    private String paymentMethodType;

    private Amount amount;

    @JsonProperty("card_info")
    private CardInfo cardInfo;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("item_code")
    private String itemCode;

    private Integer quantity;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("approved_at")
    private LocalDateTime approvedAt;

    private String payload;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Amount {
        private Integer total;
        @JsonProperty("tax_free")
        private Integer taxFree;
        private Integer vat;
        private Integer point;
        private Integer discount;
        @JsonProperty("green_deposit")
        private Integer greenDeposit;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CardInfo {
        @JsonProperty("kakaopay_purchase_corp")
        private String kakaopayPurchaseCorp;

        @JsonProperty("kakaopay_purchase_corp_code")
        private String kakaopayPurchaseCorpCode;

        @JsonProperty("kakaopay_issuer_corp")
        private String kakaopayIssuerCorp;

        @JsonProperty("kakaopay_issuer_corp_code")
        private String kakaopayIssuerCorpCode;

        private String bin;

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("install_month")
        private String installMonth;

        @JsonProperty("approved_id")
        private String approvedId;

        @JsonProperty("card_mid")
        private String cardMid;

        @JsonProperty("interest_free_install")
        private String interestFreeInstall;

        @JsonProperty("installment_type")
        private String installmentType;

        @JsonProperty("card_item_code")
        private String cardItemCode;
    }
}
