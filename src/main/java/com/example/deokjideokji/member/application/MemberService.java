package com.example.deokjideokji.member.application;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.member.AlreadyExistMemberEmailException;
import com.example.deokjideokji.error.exception.member.InvalidLoginInfoException;
import com.example.deokjideokji.member.domain.Member;
import com.example.deokjideokji.member.dto.request.CreateMemberRequest;
import com.example.deokjideokji.member.dto.response.MemberResponse;
import com.example.deokjideokji.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * @brief   유저 회원 가입
     * @param   request : 회원가입 유저 정보 Dto
     * @return  MemberResponse : 회원 정보 ResponseDto
     */
    @Transactional
    public MemberResponse signUpMember(CreateMemberRequest request) {
        duplicateValidationMemberEmail(request.getEmail());
        var response = memberRepository.save(request.toEntity());

        return response.toResponseDto();
    }

    /**
     * @brief   모든 유저 조회
     * @return  List<MemberResponse> : 회원 모든 회원 정보 List
     */
    public List<MemberResponse> searchAllMember() {
        return memberRepository.findAll().stream()
                .map(Member::toResponseDto)
                .collect(Collectors.toList());
    }



    /**
     * @brief   이메일 중복 확인
     */
    @Transactional(readOnly = true)
    public void duplicateValidationMemberEmail(String email){
        memberRepository.findByEmail(email)
                .ifPresent(member -> {
                    throw new AlreadyExistMemberEmailException(ErrorMessage.ALREADY_EXIST_MEMBER_EMAIL_EXCEPTION, "이미 존재하는 이메일 정보입니다");
                });
    }

    /**
     * @brief   유저 id 조회
     */
    @Transactional(readOnly = true)
    public Member findByIdFromLogin(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new InvalidLoginInfoException(ErrorMessage.INVALID_LOGIN_USER_INFORMATION_EXCEPTION, "잘못된 유저 로그인 정보입니다"));
    }
}
