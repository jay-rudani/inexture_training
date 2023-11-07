package org.icc.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(InvalidCurrencyCodeException.class)
    @ResponseBody
    public String handleInvalidCurrencyCodeException(InvalidCurrencyCodeException exception) {
        return messageSource.getMessage("invalid.currency.code.exception.message", new Object[]{exception.getConvertFrom(), exception.getConvertTo()}, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(SameCurrencyCodeException.class)
    public String handleSameCurrencyCodeException(SameCurrencyCodeException exception) {
        return messageSource.getMessage("same.currency.code.exception.message", new Object[]{exception.getConvertFrom(), exception.getConvertTo()}, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(InvalidAmountFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleInvalidFormatOfAmountException() {
        return messageSource.getMessage("invalid.amount.format.exception.message", null, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNumberFormatException() {
        return messageSource.getMessage("number.format.exception.message", null, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(UnknownCurrencyCodeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownCurrencyCodeException(UnknownCurrencyCodeException exception) {
        return messageSource.getMessage("unknown.currency.code.exception.message", new Object[]{exception.getResult(), exception.getError_type()}, LocaleContextHolder.getLocale());
    }

}
