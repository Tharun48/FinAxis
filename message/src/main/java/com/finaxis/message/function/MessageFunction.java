package com.finaxis.message.function;

import com.finaxis.message.dto.AccountDTO;
import com.finaxis.message.dto.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
@Configuration
public class MessageFunction {

    private static final Logger log =  LoggerFactory.getLogger(MessageFunction.class);

    @Bean
    public Function<AccountDTO,AccountDTO> accountDetails(){
        return accountDTO -> {
            log.info("account group = " + accountDTO.toString());
            return accountDTO;
        };
    }

    @Bean
    public Function<AccountDTO,AccountDTO> accountDetails1(){
        return accountDTO -> {
            log.info("message group = " + accountDTO.toString());
            return accountDTO;
        };
    }


    @Bean
    public Function<AccountDTO,Long> accountNumber(){
        return accountDTO -> {
            return accountDTO.accountNumber();
        };
    }

}
