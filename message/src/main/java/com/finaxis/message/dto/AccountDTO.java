package com.finaxis.message.dto;

public record AccountDTO(
        String accountId,
        long accountNumber,
        String address,
        int age,
        long cardNumber,
        String email,
        String name
) {
}
