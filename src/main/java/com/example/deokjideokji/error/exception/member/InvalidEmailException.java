package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException(ErrorMessage message) {
        super(message);
    }

    public InvalidEmailException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
