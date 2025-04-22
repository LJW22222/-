package com.ljw.syncpay.domain.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private final Long userId;

    private final String nickname;

    private final int profileViewCount;

    private final LocalDateTime profileCreatedAt;

    public User(Long userId, String nickname, int profileViewCount, LocalDateTime profileCreatedAt) {
        this.userId = userId;
        this.nickname = nickname;
        this.profileViewCount = profileViewCount;
        this.profileCreatedAt = profileCreatedAt;
    }
}
