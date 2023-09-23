package com.example.deokjideokji.auth.application;


import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.domain.vo.RoleType;
import com.example.deokjideokji.auth.token.TokenProvider;
import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.auth.NotExistMemberException;
import com.example.deokjideokji.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    /**
     * @brief      * 유저 조회
     * @param      * id : 파싱한 token Long userID
     * @return     * userId 조회를 통한 UserDetail
     */
    @Transactional(readOnly = true)
    public UserDetail loadUserById(String id) {
        var member =  memberRepository.findById(id)
                .orElseThrow(() -> new NotExistMemberException(ErrorMessage.NOT_EXIST_MEMBER_EXCEPTION, "해당 유저 정보가 존재하지 않습니다."));

        return new UserDetail(member);
    }

}