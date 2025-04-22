package com.ljw.syncpay.application.user.port;

import com.ljw.syncpay.application.user.dto.UserProfileInfo;
import org.springframework.data.domain.Page;


public interface UserUseCasePort {

    Page<UserProfileInfo> getUserProfiles();

}
