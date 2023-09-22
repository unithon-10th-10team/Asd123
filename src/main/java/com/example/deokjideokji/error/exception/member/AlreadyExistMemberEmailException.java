package com.example.deokjideokji.error.exception.member;

import com.example.deokjideokji.error.dto.ErrorMessage;
import com.example.deokjideokji.error.exception.BusinessException;

public class AlreadyExistMemberEmailException extends BusinessException {

    public AlreadyExistMemberEmailException(ErrorMessage message, String reason) {
        super(message, reason);
    }

    public AlreadyExistMemberEmailException(ErrorMessage message) {
        super(message);
    }
}
