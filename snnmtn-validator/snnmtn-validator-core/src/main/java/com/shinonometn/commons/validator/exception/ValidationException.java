package com.shinonometn.commons.validator.exception;


import com.shinonometn.commons.validator.ValidateResult;

public class ValidationException extends RuntimeException {

    private String error = "validation_error";
    private ValidateResult result;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String error, String message) {
        super(message);
        this.error = error;
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(ValidateResult result) {
        this.result = result;
    }

    public ValidateResult getResult() {
        return result;
    }

    public String getError() {
        return error;
    }
}
