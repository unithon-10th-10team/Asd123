package com.example.deokjideokji.member.presentaion;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.infrastructure.annotation.AuthMember;
import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import com.example.deokjideokji.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    /**
     * @brief  유저 조회
     * @return  List<MemberResponse> : 회원 모든 회원 정보 List
     */
    @GetMapping
    public ResponseEntity<?> searchAllMember(@AuthMember UserDetail detail) {
        var response = memberService.searchAllMember(detail);

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_SEARCH_ALL_MEMBER, response);
    }
}
