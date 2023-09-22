package com.example.deokjideokji.error.exception.auth;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class NotExistMemberException extends BusinessException {
    public NotExistMemberException(ErrorMessage message) {
        super(message);
    }

    public NotExistMemberException(ErrorMessage message, String reason) {
        super(message, reason);
    }
}
