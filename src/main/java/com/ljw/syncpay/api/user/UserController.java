package com.ljw.syncpay.api.user;

import com.ljw.syncpay.api.global.dto.Response;
import com.ljw.syncpay.api.user.dto.UserProfileResponse;
import com.ljw.syncpay.application.user.port.UserUseCasePort;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserUseCasePort userUseCasePort;

    @GetMapping("/profiles")
    public Response<Page<UserProfileResponse>> getUserProfileList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return Response.success(userUseCasePort.getUserProfiles());
    }

}
