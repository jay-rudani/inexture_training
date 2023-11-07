package org.icc.exception;

public class SameCurrencyCodeException extends RuntimeException {

    private String convertFrom;
    private String convertTo;

    public SameCurrencyCodeException(String message) {
        super(message);
    }

    public SameCurrencyCodeException(String convertFrom, String convertTo) {
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
