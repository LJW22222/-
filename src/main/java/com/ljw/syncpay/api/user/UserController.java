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

    /**
     * 모든 사용자의 프로필을 조회한다. [ sorted : NICKNAME, VISITED, CREATE_AT ]
     * NICKNAME -> 닉네임
     * VISITED -> 조회수
     * CREATE_AT -> 등록일
     * 모든 정렬은 오름차순으로 정렬된다.
     * @param page
     * @param size
     * @param sortType
     * @return
     */
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

    /**
     * 사용자의 프로필 방문 시, 조회수를 카운팅 한다.
     * 여기서 24H를 기준으로, 중복 조회수 카운팅을 방지한다.
     * 하루가 지나면 다시 조회수 카운팅을 할 수 있다.
     * 본인이 본인의 프로필 조회 시, 카운팅은 이루어지지 않는다.
     * @param updateUserProfileVIewCountRequest
     * @return
     */
    @PutMapping("/visited")
    public Response<User> updateUserProfileViewCount(
            @RequestBody UpdateUserProfileVIewCountRequest updateUserProfileVIewCountRequest
    ) {
        User user = userUseCasePort.updateUserProfileViewCount(updateUserProfileVIewCountRequest.userId());
        return Response.success(user);
    }
}
