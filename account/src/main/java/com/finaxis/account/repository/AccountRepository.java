package com.finaxis.account.repository;

import com.finaxis.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByAccountId(int accountId);
    Account findByAccountNumber(long accountRef);
}
