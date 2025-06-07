package com.finaxis.account.model;

public record AccountDTO(
        int accountId,
        long accountNumber,
        String address,
        int age,
        long cardNumber,
        String email,
        String name
) {
}
