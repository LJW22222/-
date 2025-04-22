package com.ljw.syncpay.application.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserProfileInfo {

    private final String nickname;
    private final  int profileViewCount;
    private final  LocalDateTime profileCreatedAt;

}
