package com.finaxis.cards.rest;

import com.finaxis.cards.model.Cards;
import com.finaxis.cards.service.CardsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardsRestController {

    CardsService cardsService;
    CardsRestController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @PostMapping("/cards")
    public int createCardDetails(@RequestBody Cards cards) {
        return cardsService.createCards(cards);
    }

    @PutMapping("/cards")
    public int updateCardDetails(@RequestBody Cards cards) {
        return cardsService.updateCards(cards);
    }

    @GetMapping("/cards/{cardId}")
    public Cards getCardDetails(@PathVariable int cardId) {
        return cardsService.getCards(cardId);
    }

    @DeleteMapping("/cards/{cardId}")
    public int deleteCardDetails(@PathVariable  int cardId) {
        return cardsService.deleteCards(cardId);
    }

    @GetMapping("/cards/account/{accountNumber}")
    public List<Cards> getCardDetailsByAccountNumber(@PathVariable Long accountNumber) {
        return cardsService.getCardsByAccountNumber(accountNumber);
    }


}
