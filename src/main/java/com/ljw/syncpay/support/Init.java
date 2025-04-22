package com.ljw.syncpay.support;

import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.persistence.user.UserEntity;
import com.ljw.syncpay.persistence.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Init {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        LocalDateTime time = LocalDateTime.now();
        Random random = new Random();
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            int randomTime = random.nextInt(3 * 60 * 60);
            LocalDateTime createdAt = time.plusSeconds(randomTime);
            UserEntity userEntity = new UserEntity("testNo" + i, 0, createdAt);
            list.add(userEntity);
        }
        userRepository.saveAll(list);
    }

}
