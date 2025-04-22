package com.ljw.syncpay.persistence.adapter;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.port.UserQueryPort;
import com.ljw.syncpay.persistence.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserQueryAdapter implements UserQueryPort {

    private final UserRepository userRepository;

    public List<User> getUserProfiles() {

    }

}
