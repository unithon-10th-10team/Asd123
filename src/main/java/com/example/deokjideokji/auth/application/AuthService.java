package com.example.deokjideokji.auth.application;


import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.domain.vo.RoleType;
import com.example.deokjideokji.auth.token.TokenProvider;
import com.example.deokjideokji.common.header.HeaderUtil;
import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.auth.NotExistMemberException;
import com.example.deokjideokji.member.domain.Member;
import com.example.deokjideokji.member.infrastructure.MemberRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    @Value("${kakao.client.registration.client-id}")
    private String kakaoApiKey;

    @Value("${kakao.client.provider.user-info-uri}")
    private String kakaoUserUri;

    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;

    /**
     * @brief      * 유저 조회
     * @param      * id : 파싱한 token Long userID
     * @return     * userId 조회를 통한 UserDetail
     */
    @Transactional(readOnly = true)
    public UserDetail loadUserById(Long id) {
        var member =  memberRepository.findById(id)
                .orElseThrow(() -> new NotExistMemberException(ErrorMessage.NOT_EXIST_MEMBER_EXCEPTION, "해당 유저 정보가 존재하지 않습니다."));

        return new UserDetail(member);
    }

    /**
     * @brief      * 유저 로그인
     * @todo 카카오 토큰을 통한 로그인 구현 예정
     * @param      * code : kokao access toekn
     * @return     * jwt token : 조회한 유저 정보 id, role 이용한 jwt token
     */
    @Transactional
    public String userSignUp(HttpServletRequest request) throws ParseException {
        var token = HeaderUtil.getAccessToken(request);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = rt.exchange(
                kakaoUserUri,
                HttpMethod.POST,
                httpEntity,
                String.class
        );

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj    = (JSONObject) jsonParser.parse(response.getBody());
        String account = jsonObj.get("email").toString();
        String nickname = jsonObj.get("nickname").toString();
        String birthday = jsonObj.get("birthday").toString();

        return loadMember(account, nickname, birthday);
    }

    @Transactional
    public String loadMember(String account, String nickname, String birthday) {
        var member = new Member(account, nickname, birthday);
        var memberId = memberRepository.findByEmail(account).orElse(
                memberRepository.save(member)
        ).getId();

        return tokenProvider.generateJwtToken(memberId, "ROLE_USER");
    }

}