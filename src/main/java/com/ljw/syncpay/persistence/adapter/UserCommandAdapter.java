package com.ljw.syncpay.persistence.adapter;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.port.UserCommandPort;
import com.ljw.syncpay.persistence.user.UserEntity;
import com.ljw.syncpay.persistence.user.repository.UserRepository;
import com.ljw.syncpay.persistence.user.support.UserToDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserCommandAdapter implements UserCommandPort{

    private final UserRepository userRepository;

    @Override
    public User updateUserProfileViewCount(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        return UserToDomain.to(userEntity);
    }

    @Override
    public void updateUserPoint(Long userId, int point) {
        UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        userEntity.updatePoint(point);
    }

}
