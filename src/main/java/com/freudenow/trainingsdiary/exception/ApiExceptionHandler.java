package com.freudenow.trainingsdiary.exception;

import org.springframework.http.ResponseEntity;

public class ApiExceptionHandler {
    public ApiRequestException handleApiREquestException (ApiRequestException exception){
        return exception;
    }
}
