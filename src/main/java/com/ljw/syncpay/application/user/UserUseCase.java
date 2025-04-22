package com.ljw.syncpay.application.user;

import com.ljw.syncpay.application.user.port.UserUseCasePort;
import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.port.UserCommandPort;
import com.ljw.syncpay.domain.user.port.UserQueryPort;
import com.ljw.syncpay.domain.user.vo.SortType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase implements UserUseCasePort {

    private final UserQueryPort userQueryPort;
    private final UserCommandPort userCommandPort;

    @Override
    public Page<User> getUserProfiles(int page, int size, SortType sortType) {
        return userQueryPort.getUserProfiles(page, size, sortType.converter());
    }

    @Override
    public User updateUserProfileViewCount(Long userId) {
        return userCommandPort.updateUserProfileViewCount(userId);
    }
}
