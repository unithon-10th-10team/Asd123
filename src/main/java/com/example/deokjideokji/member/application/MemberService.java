package com.example.deokjideokji.member.application;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.token.TokenProvider;
import com.example.deokjideokji.common.header.HeaderUtil;
import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.auth.NotLoginUserException;
import com.example.deokjideokji.member.domain.Member;
import com.example.deokjideokji.member.dto.response.MemberResponse;
import com.example.deokjideokji.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final TokenProvider tokenProvider;

    private final MemberRepository memberRepository;

    /**
     * @brief   모든 유저 조회
     * @return  List<MemberResponse> : 회원 모든 회원 정보 List
     */
    @Transactional(readOnly = true)
    public MemberResponse searchAllMember(UserDetail detail) {
        return memberRepository.findById(detail.getId()).get().toResponseDto();
    }

    @Transactional(readOnly = true)
    public void validateUserDetail(UserDetail detail) {
        memberRepository.findById(detail.getId())
                .orElseThrow(() -> new NotLoginUserException(ErrorMessage.NOT_LOGIN_USER_EXCEPTION, "로그인 정보가 없습니다."));
    }
}
