package com.ljw.syncpay.api.user.dto;

import com.ljw.syncpay.domain.user.User;

import java.time.LocalDateTime;

public record UserProfileResponse(

        String nickname,
        int profileViewCount,
        LocalDateTime profileCreatedAt

) {

    public static UserProfileResponse to(User user) {
        return new UserProfileResponse(
                user.getNickname(),
                user.getProfileViewCount(),
                user.getProfileCreatedAt());
    }

}
