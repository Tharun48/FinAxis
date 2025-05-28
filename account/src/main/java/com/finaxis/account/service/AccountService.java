package com.finaxis.account.service;

import com.finaxis.account.model.Account;
import com.finaxis.account.model.CardDetailsDTO;

public interface AccountService {
    int saveAccountDetails(Account account);
    int modifyAccountDetails(Account account);
    int deleteAccountDetails(int accountId);
    Account getAccountDetails(int accountId);
    CardDetailsDTO fecthCardDetailsOfUser(int accountRef);
}
