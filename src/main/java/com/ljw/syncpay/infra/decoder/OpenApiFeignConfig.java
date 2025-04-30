package com.ljw.syncpay.infra.decoder;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiFeignConfig {

    @Bean
    public ErrorDecoder kakaoErrorDecoder() {
        return new PayFeignErrorDecoder();
    }
}
