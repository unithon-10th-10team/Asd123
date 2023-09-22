package com.example.deokjideokji.auth.presentation;

import com.example.deokjideokji.auth.application.AuthService;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    /**
     * @brief      * 유저 로그인
     * @param      * JoinRequest : 로그인을 위한 카카오 토큰
     * @todo 카카오 토큰을 통한 로그인 구현 예정
     * @return     * jwt token : 조회한 유저 정보를 담은 jwt token
     */
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody JoinRequest request) {
//        var userDetail = authService.userLogin(request);
//
//        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_LOAD_MEMBER_INFORMATION, userDetail);
//    }


}
