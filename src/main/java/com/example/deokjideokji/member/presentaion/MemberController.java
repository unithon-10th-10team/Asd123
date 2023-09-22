package com.example.deokjideokji.member.presentaion;

import com.example.deokjideokji.common.response.dto.ResponseDto;
import com.example.deokjideokji.common.response.dto.ResponseMessage;
import com.example.deokjideokji.member.application.MemberService;
import com.example.deokjideokji.member.dto.request.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    /**
     * @brief   유저 회원 가입
     * @param   request : 회원가입 유저 정보 Dto
     * @todo    이후 토큰이 있는 상태라면 진행이 불가능하도록 추가 예정,
     * @return  MemberResponse : 회원 정보 ResponseDto
     */
    @PostMapping("/signup")
    public ResponseEntity<?> joinMember(@RequestBody @Valid CreateMemberRequest request) {
        var response = memberService.signUpMember(request);

        return ResponseDto.toResponseEntity(ResponseMessage.CREATE_SUCCESS_MEMBER, response);
    }

    /**
     * @brief   모든 유저 조회
     * @return  List<MemberResponse> : 회원 모든 회원 정보 List
     */
    @GetMapping
    public ResponseEntity<?> searchAllMember() {
        var response = memberService.searchAllMember();

        return ResponseDto.toResponseEntity(ResponseMessage.SUCCESS_SEARCH_ALL_MEMBER, response);
    }
}
