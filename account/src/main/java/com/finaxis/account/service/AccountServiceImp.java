package com.finaxis.account.service;

import com.finaxis.account.model.Account;
import com.finaxis.account.model.AccountDTO;
import com.finaxis.account.model.CardDTO;
import com.finaxis.account.model.CardDetailsDTO;
import com.finaxis.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.TreeMap;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;
    private final StreamBridge streamBridge;
    private final Logger log = LoggerFactory.getLogger(AccountServiceImp.class);



    @Override
    public int saveAccountDetails(Account account) {
        Account savedAccount = accountRepository.save(account);
        Account_Publish(savedAccount);
        return savedAccount.getAccountId();
    }

    private void Account_Publish(Account account) {
        AccountDTO accountDTO = new AccountDTO(account.getAccountId(),account.getAccountNumber(),
                account.getAddress(),account.getAge(),account.getCardNumber(),account.getEmail(),account.getName());
        var result = streamBridge.send("send-communication-out-0", accountDTO);
        //event published
        log.info("Is event published " + result);
    }
    @Override
    public int modifyAccountDetails(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getAccountId();
    }

    @Override
    public int deleteAccountDetails(int accountId) {
        Account account = getAccountDetails(accountId);
        accountRepository.delete(account);
        return accountId;
    }

    @Override
    public Account getAccountDetails(int accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public CardDetailsDTO fecthCardDetailsOfUser(long accountRef) {
        Account account = accountRepository.findByAccountNumber(accountRef);
        if(account!=null) {
            ArrayList list = restTemplate.getForObject("http://localhost:8081/cards/account/147258369", ArrayList.class);
            CardDTO cardDTO = restTemplate.getForObject("http://localhost:8081/cards/1", CardDTO.class);
            System.out.println("list =  "+list);
            System.out.println("card-dto =  "+cardDTO);
            CardDetailsDTO cardDetailsDTO = new CardDetailsDTO(account.getAccountId(),account.getAccountNumber(),account.getAddress(),
                    account.getAge(),account.getCardNumber(),account.getEmail(),account.getName(),list,cardDTO);
            return cardDetailsDTO;
        }
        return null;
    }
}
