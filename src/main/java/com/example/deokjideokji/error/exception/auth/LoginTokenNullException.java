package com.example.deokjideokji.error.exception.auth;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class LoginTokenNullException extends BusinessException {
    public LoginTokenNullException(ErrorMessage message) {
        super(message);
    }

    public LoginTokenNullException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
