package com.example.deokjideokji.map.application;

import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.domain.vo.RoleType;
import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.auth.LoginTokenNullException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
@Slf4j
public class MapService {
    @Value("${kakao.client.registration.client-id}")
    private String kakaoApiKey;

    public JSONObject getLocationMap(UserDetail detail, Double lat, Double lon) {
        loginCheckException(detail);

        BufferedReader br = null;
        JSONObject obj = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=" + lon + "&y=" + lat);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", "KakaoAK " + kakaoApiKey);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if(br != null) obj = mapper.readValue(br, JSONObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;
    }

    private void loginCheckException(UserDetail detail) {
        if(detail.getRole() == RoleType.GUEST) {
            throw new LoginTokenNullException(ErrorMessage.NOT_LOGIN_USER_EXCEPTION, "로그인 정보가 없습니다");
        }
    }
}
