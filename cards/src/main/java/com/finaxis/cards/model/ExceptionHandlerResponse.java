package com.finaxis.cards.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExceptionHandlerResponse {
    String message;
    int status;
    long date;
}
