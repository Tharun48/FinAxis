package com.finaxis.account.rest;

import com.finaxis.account.model.Account;
import com.finaxis.account.model.CardDetailsDTO;
import com.finaxis.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountService accountService;
    @Autowired
    AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/account")
    public int createAccount(Account account) {
        return accountService.saveAccountDetails(account);
    }

    @PutMapping("/account")
    public int updateAccount(Account account) {
        return accountService.modifyAccountDetails(account);
    }



    @GetMapping("/account/{accountRef}")
    public ResponseEntity<CardDetailsDTO> fecthCardDetailsOfUser(@PathVariable long accountRef) {
        CardDetailsDTO cardDetailsDTO = accountService.fecthCardDetailsOfUser(accountRef);
        return ResponseEntity.ok(cardDetailsDTO);
    }



}
