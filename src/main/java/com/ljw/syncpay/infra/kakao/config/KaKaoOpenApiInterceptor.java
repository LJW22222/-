package com.ljw.syncpay.infra.kakao.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class KaKaoOpenApiInterceptor implements RequestInterceptor {

    @Value("${payment.kakao.SECRET_KEY}")
    private String serviceKey;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Content-type", "application/json");
        template.header("Authorization", "SECRET_KEY " + serviceKey);
    }
}
