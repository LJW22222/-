package com.ljw.syncpay.infra.decoder;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class PayFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String body = response.body() != null
                    ? Util.toString(response.body().asReader(StandardCharsets.UTF_8))
                    : "No response body";

            log.error("Feign 호출 실패 - [{}] status: {}\nresponse body: {}",
                    methodKey, response.status(), body);

            return new RuntimeException("Feign error: " + body);
        } catch (IOException e) {
            return new RuntimeException("Feign error (body read fail): " + e.getMessage());
        }
    }
}
