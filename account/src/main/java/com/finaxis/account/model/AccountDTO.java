package com.finaxis.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AccountDTO(

        @JsonProperty("account-id")
        int accountId,

        @JsonProperty("account-number")
        long accountNumber,

        @JsonProperty("address")
        String address,

        @JsonProperty("age")
        int age,

        @JsonProperty("card-number")
        long cardNumber,

        @JsonProperty("email")
        String email,

        @NotNull(message = "name should be specified")
        String name
) {
}
