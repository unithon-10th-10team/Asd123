package com.example.deokjideokji.auth.infrastructure.authentication;


import com.example.deokjideokji.auth.domain.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface GetAuthenticationStrategy {
    Authentication get(HttpServletRequest request);
}

