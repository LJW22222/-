package com.ljw.syncpay.infra.adapter;

import com.ljw.syncpay.domain.user.port.RedisCommandPort;
import com.ljw.syncpay.domain.user.port.RedisQueryPort;
import com.ljw.syncpay.infra.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisAdapter implements RedisCommandPort, RedisQueryPort {

    private final RedisService redisService;


    @Override
    public boolean findUserId(long userId) {
        return redisService.findUserId(userId);
    }

    @Override
    public void setUserId(long userId) {
        redisService.setUserId(userId);
    }
}
