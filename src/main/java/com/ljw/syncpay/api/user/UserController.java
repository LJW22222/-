package com.ljw.syncpay.api.user;

import com.ljw.syncpay.api.global.dto.Response;
import com.ljw.syncpay.api.user.dto.UpdateUserProfileVIewCountRequest;
import com.ljw.syncpay.api.user.dto.UserProfileResponse;
import com.ljw.syncpay.application.user.port.UserUseCasePort;
import com.ljw.syncpay.domain.user.User;
import com.ljw.syncpay.domain.user.vo.SortType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserUseCasePort userUseCasePort;

    @GetMapping("/profiles")
    public Response<Page<UserProfileResponse>> getUserProfileList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam (defaultValue = "NICKNAME") SortType sortType
    ) {
        Page<User> userProfiles = userUseCasePort.getUserProfiles(page, size, sortType);
        Page<UserProfileResponse> responsePage = userProfiles.map(UserProfileResponse::to);
        return Response.success(responsePage);
    }

    @PutMapping("/visited")
    public Response<User> updateUserProfileViewCount(
            @RequestBody UpdateUserProfileVIewCountRequest updateUserProfileVIewCountRequest
    ) {
        User user = userUseCasePort.updateUserProfileViewCount(updateUserProfileVIewCountRequest.userId());
        return Response.success(user);
    }
}
