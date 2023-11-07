package org.icc.exception;

public class InvalidAmountFormatException extends RuntimeException {

    public InvalidAmountFormatException(String message) {
        super(message);
    }

    public InvalidAmountFormatException() {
    }
}
