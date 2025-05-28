package com.finaxis.cards.repository;

import com.finaxis.cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards,Integer> {
    Cards findByCardNumber(long cardNumber);
    List<Cards> findByAccountNumber(long accountNumber);
    Cards findByCardId(int cardId);
}
