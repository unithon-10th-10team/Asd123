package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class InvalidNameException extends BusinessException {
    public InvalidNameException(ErrorMessage message) {
        super(message);
    }

    public InvalidNameException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
