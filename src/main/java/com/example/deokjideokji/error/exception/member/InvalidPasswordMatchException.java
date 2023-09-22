package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class InvalidPasswordMatchException extends BusinessException {
    public InvalidPasswordMatchException(ErrorMessage message) {
        super(message);
    }

    public InvalidPasswordMatchException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}