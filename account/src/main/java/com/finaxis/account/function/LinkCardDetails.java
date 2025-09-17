package com.finaxis.account.function;

import com.finaxis.account.model.Account;
import com.finaxis.account.model.CardDetailsDTO;
import com.finaxis.account.repository.AccountRepository;
import com.finaxis.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
@Configuration
@AllArgsConstructor
public class LinkCardDetails {

    private static final Logger log = LoggerFactory.getLogger(LinkCardDetails.class);
    private final AccountRepository accountrepository;
    private final AccountService accountService;
    //dependency of function has to be added only we use want to define or it can be supplier
    //pattern to the lambda expression...
    /*
    (input parameter1, input parameter2) ->{
	    //logic goes here...
    }
     */
    @Bean
    public Function<CardDetailsDTO,Long> cardDetails(){
        log.info("tharun");
        return cardDetailsDTO -> {
            long accountNumber = cardDetailsDTO.accountNumber();
            Account account = accountrepository.findByAccountNumber(accountNumber);
            account.setCardNumber(cardDetailsDTO.cardNumber());
            accountService.modifyAccountDetails(account);
            return cardDetailsDTO.cardNumber();
        };
    }

    @Bean
    public Function<CardDetailsDTO,Long> cardDetails1(){
        log.info("tharun");
        return cardDetailsDTO -> {
            long accountNumber = cardDetailsDTO.accountNumber();
            Account account = accountrepository.findByAccountNumber(accountNumber);
            account.setCardNumber(cardDetailsDTO.cardNumber());
            accountService.modifyAccountDetails(account);
            return cardDetailsDTO.cardNumber();
        };
    }

}
