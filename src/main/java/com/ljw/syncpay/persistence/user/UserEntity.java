package com.ljw.syncpay.persistence.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nickname;

    private int profileViewCount;

    private LocalDateTime profileCreatedAt;

    @Builder
    public UserEntity(String nickname, int profileViewCount, LocalDateTime profileCreatedAt) {
        this.nickname = nickname;
        this.profileViewCount = profileViewCount;
        this.profileCreatedAt = profileCreatedAt;
    }
}
