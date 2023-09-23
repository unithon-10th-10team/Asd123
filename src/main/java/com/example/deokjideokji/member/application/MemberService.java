package com.example.deokjideokji.member.application;

import com.example.deokjideokji.member.domain.Member;
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
     * @brief   모든 유저 조회
     * @return  List<MemberResponse> : 회원 모든 회원 정보 List
     */
    @Transactional(readOnly = true)
    public List<MemberResponse> searchAllMember() {
        return memberRepository.findAll().stream()
                .map(Member::toResponseDto)
                .collect(Collectors.toList());
    }
}
