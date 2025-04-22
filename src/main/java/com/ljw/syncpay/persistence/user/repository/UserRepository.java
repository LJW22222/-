package com.ljw.syncpay.persistence.user.repository;

import com.ljw.syncpay.persistence.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findAll(Pageable pageable);

    Optional<UserEntity> findByUserId(Long userId);
}
