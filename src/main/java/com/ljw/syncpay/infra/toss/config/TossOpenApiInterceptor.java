package com.ljw.syncpay.infra.toss.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TossOpenApiInterceptor implements RequestInterceptor {

    @Value("${toss.SECRET_KEY}")
    private String serviceKey;

    @Override
    public void apply(RequestTemplate template) {
        String encodedKey = Base64.getEncoder().encodeToString((serviceKey + ":").getBytes(StandardCharsets.UTF_8));
        template.header("Content-type", "application/json");
        template.header("Authorization", "Basic " + encodedKey);
    }
}
