package org.icc.exception;

public class UnknownCurrencyCodeException extends RuntimeException {

    private String result;
    private String error_type;

    public UnknownCurrencyCodeException(String message) {
        super(message);
    }

    public UnknownCurrencyCodeException(String result, String error_type) {
        this.error_type = error_type;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getError_type() {
        return error_type;
    }
}
