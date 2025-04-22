package com.ljw.syncpay.persistence.adapter;

import com.ljw.syncpay.domain.user.port.UserCommandPort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserCommandAdapter implements UserCommandPort{
}
