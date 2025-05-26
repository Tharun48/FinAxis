package com.finaxis.cards.rest;

import com.finaxis.cards.model.Cards;
import com.finaxis.cards.service.CardsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardsRestController {

    CardsService cardsService;
    CardsRestController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @PostMapping("/cards")
    public int createCardDetails(Cards cards) {
        return cardsService.createCards(cards);
    }

    @PutMapping("/cards")
    public int updateCardDetails(Cards cards) {
        return cardsService.updateCards(cards);
    }

    @GetMapping("/cards/{cardId}")
    public Cards getCardDetails(int cardId) {
        return cardsService.getCards(cardId);
    }

    @DeleteMapping("/cards/{cardId}")
    public int deleteCardDetails(int cardId) {
        return cardsService.deleteCards(cardId);
    }


}
