package com.finaxis.cards.service;

import com.finaxis.cards.model.AccountDTO;
import com.finaxis.cards.model.Cards;
import com.finaxis.cards.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements CardsService{

    private final CardsRepository cardsRepository;
    private final StreamBridge streamBridge;
    private static final Logger log = LoggerFactory.getLogger(CardsServiceImpl.class);
    private final RestTemplate restTemplate;

    private boolean isAccountValid(long accountNumber) {
        AccountDTO accountDTO = restTemplate.getForObject("http://localhost:8080/account/"+String.valueOf(accountNumber), AccountDTO.class);
        return accountDTO!=null;
    }

    @Override
    public int createCards(Cards cards) {
        cards.setCardId(0);
        Cards savedCards = cardsRepository.save(cards);
        if(isAccountValid(cards.getAccountNumber())) {
            publishCardDetails(savedCards);
            return savedCards.getCardId();
        }
        else{
            throw new RuntimeException("account details not found for the account number = " + cards.getAccountNumber());
        }
    }

    private void publishCardDetails(Cards cards){
        log.info("message publish started");
        var result = streamBridge.send("card-details",cards);
        log.info("event published " +result);
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

    @Override
    public List<Cards> getCardsByAccountNumber(long accountNumber) {
        return cardsRepository.findByAccountNumber(accountNumber);
    }
}
