package org.icc.exception;

public class InvalidCurrencyCodeException extends RuntimeException {

    private String convertFrom;
    private String convertTo;

    public InvalidCurrencyCodeException(String message) {
        super(message);
    }

    public InvalidCurrencyCodeException(String convertFrom, String convertTo) {
        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }
}
