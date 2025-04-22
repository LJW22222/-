package com.ljw.syncpay.api.user.dto;

import com.ljw.syncpay.application.user.dto.UserProfileInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserProfileResponse(

        String nickname,
        int profileViewCount,
        LocalDateTime profileCreatedAt

) {

    public static UserProfileResponse to(UserProfileInfo userProfileInfo) {
        return new UserProfileResponse(
                userProfileInfo.getNickname(),
                userProfileInfo.getProfileViewCount(),
                userProfileInfo.getProfileCreatedAt());
    }

}
