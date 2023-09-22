package com.example.deokjideokji.auth.infrastructure.authentication;


import com.example.deokjideokji.auth.domain.Authentication;

public interface SetAuthenticationStrategy {
    void set(Authentication authentication);
}
