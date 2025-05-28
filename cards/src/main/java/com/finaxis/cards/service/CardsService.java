package com.finaxis.cards.service;

import com.finaxis.cards.model.Cards;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CardsService {
    int createCards(Cards cards);
    int updateCards(Cards cards);
    int deleteCards(int cardId);
    Cards getCards(int cardId);
    List<Cards> getCardsByAccountNumber(long accountNumber);
}
