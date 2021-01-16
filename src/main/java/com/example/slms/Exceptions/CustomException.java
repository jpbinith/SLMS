package com.example.slms.Exceptions;

public class CustomException extends RuntimeException {
//    private static final long serialVersionUID = 1L;
    private final int errorCode;
    private final String message;

    public CustomException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

