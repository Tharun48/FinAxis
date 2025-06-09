package com.finaxis.cards.exception;

import com.finaxis.cards.model.ExceptionHandlerResponse;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.springframework.boot.autoconfigure.batch.BatchTaskExecutor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ExceptionHandlerResponse> exception(RuntimeException e) {
        ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse();
        exceptionHandlerResponse.setMessage(e.getMessage());
        exceptionHandlerResponse.setStatus(HttpStatus.SC_NOT_FOUND);
        exceptionHandlerResponse.setDate(System.currentTimeMillis());
        return new ResponseEntity<>(exceptionHandlerResponse, HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));
    }

}
