package com.example.deokjideokji.error.exception.auth;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class NotLoginUserException extends BusinessException {
    public NotLoginUserException(ErrorMessage message) {
        super(message);
    }

    public NotLoginUserException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
