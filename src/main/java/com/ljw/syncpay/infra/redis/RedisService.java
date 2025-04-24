package com.ljw.syncpay.infra.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public void setUserId(long userId) {
        LocalDateTime time = LocalDateTime.now();
        redisTemplate.opsForValue().set(String.valueOf(userId), time.toString(), Duration.ofDays(1));
    }

    public boolean findUserId(long userId) {
        return redisTemplate.hasKey(String.valueOf(userId));
    }

}
