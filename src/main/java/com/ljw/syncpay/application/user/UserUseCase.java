package com.ljw.syncpay.application.user;

import com.ljw.syncpay.application.user.dto.UserProfileInfo;
import com.ljw.syncpay.application.user.port.UserUseCasePort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCase implements UserUseCasePort {



    @Override
    public Page<UserProfileInfo> getUserProfiles() {
        return null;
    }
}
