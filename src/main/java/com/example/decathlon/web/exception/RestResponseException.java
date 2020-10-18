package com.example.decathlon.web.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class RestResponseException {

    private final String code;
    private final List<String> errors;
}
