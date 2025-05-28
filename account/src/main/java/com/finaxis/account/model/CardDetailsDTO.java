package com.finaxis.account.model;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public record CardDetailsDTO(
        int accountId,
        long accountNumber,
        String address,
        int age,
        long cardNumber,
        String email,
        String name,
        ArrayList cards,
        CardDTO firstCard
) {
}
