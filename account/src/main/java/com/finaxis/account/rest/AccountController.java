package com.finaxis.account.rest;

import com.finaxis.account.model.Account;
import com.finaxis.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
