package com.finaxis.cards.service;

import com.finaxis.cards.model.Cards;
import com.finaxis.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardsServiceImpl implements CardsService{

    CardsRepository cardsRepository;

    @Autowired
    CardsServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public int createCards(Cards cards) {
        cards.setCardId(0);
        Cards savedCards = cardsRepository.save(cards);
        return savedCards.getCardId();
    }

    @Override
    public int updateCards(Cards cards) {
        Cards savedCards = cardsRepository.save(cards);
        return savedCards.getCardId();
    }

    @Override
    public int deleteCards(int cardId) {
       Cards cards = getCards(cardId);
       cardsRepository.delete(cards);
       return cardId;
    }

    @Override
    public Cards getCards(int cardId) {
        return cardsRepository.findByCardId(cardId);
    }
}
