package com.ljw.syncpay.persistence.adapter;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.port.UserQueryPort;
import com.ljw.syncpay.persistence.user.UserEntity;
import com.ljw.syncpay.persistence.user.repository.UserRepository;
import com.ljw.syncpay.persistence.user.support.UserToDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryAdapter implements UserQueryPort {

    private final UserRepository userRepository;

    @Override
    public Page<User> getUserProfiles(int page, int size, String sortType) {
        Sort sort = Sort.by(Sort.Order.desc(sortType));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<UserEntity> userProfiles = userRepository.findAll(pageRequest);
        return userProfiles.map(UserToDomain::to);
    }

    @Override
    public User getUserInf(long id) {
        return UserToDomain.to(userRepository.findByUserId(id).get());
    }

}
