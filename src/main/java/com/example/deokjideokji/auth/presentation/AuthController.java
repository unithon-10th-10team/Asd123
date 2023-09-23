package com.example.deokjideokji.auth.presentation;

import com.example.deokjideokji.auth.application.AuthService;
import com.example.deokjideokji.common.header.HeaderUtil;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/oauth2")
public class AuthController {

    private final AuthService authService;

    /**
     * @brief      * 카카오 유저 정보가져오기 & 회원가입
     * @param      * token : FE 카카오 accessToken
     * @todo 카카오 토큰을 통한 로그인 구현 예정
     * @return     * userDetail : 조회한 유저 정보를 담은 jwt token
     */
    @PostMapping("/kakao")
    public ResponseEntity<?> login() throws ParseException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        var userDetail = authService.userSignUp(request);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_LOAD_MEMBER_INFORMATION, userDetail);
    }

}
