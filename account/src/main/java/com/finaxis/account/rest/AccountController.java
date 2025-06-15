package com.finaxis.account.rest;

import com.finaxis.account.model.Account;
import com.finaxis.account.model.AccountDTO;
import com.finaxis.account.model.AccountWrapperDTO;
import com.finaxis.account.model.CardDetailsDTO;
import com.finaxis.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountService accountService;
    @Autowired
    AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/account")
    public int createAccount(@RequestBody @Valid Account account) {
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


    @PostMapping("/account-details")
    public int createAccountDummy(@RequestBody @Valid AccountWrapperDTO account) {
        return 1;
    }



}
