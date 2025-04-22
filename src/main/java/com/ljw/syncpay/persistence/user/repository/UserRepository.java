package com.ljw.syncpay.persistence.user.repository;

import com.ljw.syncpay.persistence.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findUserProfiles();

}
