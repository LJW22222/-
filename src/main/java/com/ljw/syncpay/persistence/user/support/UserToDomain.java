package com.ljw.syncpay.persistence.user.support;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.persistence.user.UserEntity;

public class UserToDomain {

    public static User to(UserEntity user) {
        return new User(user.getUserId(), user.getNickname(), user.getProfileViewCount(), user.getProfileCreatedAt());
    }

}
