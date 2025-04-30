package com.ljw.syncpay.api.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@ToString
public class KakaoReadyResponse {
    private final String tid;

    @JsonProperty("next_redirect_app_url")
    private final String nextRedirectAppUrl;

    @JsonProperty("next_redirect_mobile_url")
    private final String nextRedirectMobileUrl;

    @JsonProperty("next_redirect_pc_url")
    private final String nextRedirectPcUrl;

    @JsonProperty("android_app_scheme")
    private final String androidAppScheme;

    @JsonProperty("ios_app_scheme")
    private final String iosAppScheme;

    @JsonProperty("created_at")
    private final LocalDateTime createdAt;

    private int totalAmount;

    public void updateTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
