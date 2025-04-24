package com.ljw.syncpay.application.user.port;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.vo.SortType;
import org.springframework.data.domain.Page;


public interface UserUseCasePort {

    Page<User> getUserProfiles(int page, int size, SortType sortType);

    User updateUserProfileViewCount(long userId);


}
