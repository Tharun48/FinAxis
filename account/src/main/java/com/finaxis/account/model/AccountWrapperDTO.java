package com.finaxis.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountWrapperDTO(
        @JsonProperty("account")
        AccountDTO account
) {
}
