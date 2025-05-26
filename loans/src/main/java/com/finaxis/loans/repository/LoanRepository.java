package com.finaxis.loans.repository;

import com.finaxis.loans.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loans, Integer> {
    Loans findByLoanId(int loanId);
}
