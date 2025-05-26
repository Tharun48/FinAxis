package com.finaxis.cards.repository;

import com.finaxis.cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Cards,Integer> {
    Cards findByCardNumber(long cardNumber);
    Cards findByCardId(int cardId);
}
