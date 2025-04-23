package com.ljw.syncpay.infra.toss.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TossPaymentConfirmReponse {

    private String mId;
    private String lastTransactionKey;
    private String paymentKey;
    private String orderId;
    private String orderName;
    private int taxExemptionAmount;
    private String status;
    private ZonedDateTime requestedAt;
    private ZonedDateTime approvedAt;
    private boolean useEscrow;
    private boolean cultureExpense;

    private Card card;
    private EasyPay easyPay;
    private Receipt receipt;
    private Checkout checkout;

    private String type;
    private String country;
    private boolean isPartialCancelable;
    private String currency;
    private int totalAmount;
    private int balanceAmount;
    private int suppliedAmount;
    private int vat;
    private int taxFreeAmount;
    private String method;
    private String version;

    @Data
    public static class Card {
        private String issuerCode;
        private String acquirerCode;
        private String number;
        private int installmentPlanMonths;
        private boolean isInterestFree;
        private String interestPayer;
        private String approveNo;
        private boolean useCardPoint;
        private String cardType;
        private String ownerType;
        private String acquireStatus;
        private int amount;
    }

    @Data
    public static class EasyPay {
        private String provider;
        private int amount;
        private int discountAmount;
    }

    @Data
    public static class Receipt {
        private String url;
    }

    @Data
    public static class Checkout {
        private String url;
    }

    public int getAmount() {
        if (card == null) {
            return easyPay.amount;
        }
        return card.amount;
    }
}
