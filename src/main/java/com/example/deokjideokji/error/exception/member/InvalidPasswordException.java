package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException(ErrorMessage message) {
        super(message);
    }

    public InvalidPasswordException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
