package com.ljw.syncpay.domain.user.port;

import com.ljw.syncpay.domain.user.User;

public interface UserCommandPort {

    User updateUserProfileViewCount(long userId);

    void updateUserPoint(long userId, int point);

}
