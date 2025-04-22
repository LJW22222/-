package com.ljw.syncpay.domain.user.port;

import com.ljw.syncpay.domain.user.User;

public interface UserCommandPort {

    User updateUserProfileViewCount(Long userId);

}
