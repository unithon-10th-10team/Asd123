package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class InvalidLoginInfoException extends BusinessException {
    public InvalidLoginInfoException(ErrorMessage message) {
        super(message);
    }

    public InvalidLoginInfoException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}