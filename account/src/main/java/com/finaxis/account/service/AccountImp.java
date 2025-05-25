package com.finaxis.account.service;

import com.finaxis.account.model.Account;
import com.finaxis.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountImp implements AccountService {

    AccountRepository accountRepository;
    @Autowired
    AccountImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public int saveAccountDetails(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getAccountId();
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
}
