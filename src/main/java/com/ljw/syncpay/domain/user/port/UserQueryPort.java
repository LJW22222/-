package com.ljw.syncpay.domain.user.port;

import com.ljw.syncpay.domain.user.User;
import org.springframework.data.domain.Page;

public interface UserQueryPort {

    Page<User> getUserProfiles(int page, int size, String sortType);
}
