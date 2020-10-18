package com.example.decathlon.web.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

import static java.util.List.of;
import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    public static final String BAD_REQUEST_RESPONSE_CODE = "400";
    public static final String INTERNAL_SERVER_ERROR_RESPONSE_CODE = "500";

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public RestResponseException handleExternalValidationException(MethodArgumentNotValidException e, Locale locale) {
        log.error(e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();

        return new RestResponseException(BAD_REQUEST_RESPONSE_CODE, bindingResult.getAllErrors().stream()
                .map(error -> messageSource.getMessage(error, locale))
                .flatMap(compile(",")::splitAsStream)
                .collect(toList()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public RestResponseException handleInternalValidationException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return new RestResponseException(BAD_REQUEST_RESPONSE_CODE, of(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public RestResponseException handleOtherException(Exception e) {
        log.error(e.getMessage(), e);
        return new RestResponseException(INTERNAL_SERVER_ERROR_RESPONSE_CODE, of(e.getMessage()));
    }
}
