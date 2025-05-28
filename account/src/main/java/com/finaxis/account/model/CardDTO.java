package com.finaxis.account.model;

import java.time.LocalDate;
public record CardDTO(
        long cardNumber,
        int cvv
) {
}
