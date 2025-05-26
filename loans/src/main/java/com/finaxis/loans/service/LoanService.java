package com.finaxis.loans.service;

import com.finaxis.loans.model.Loans;

public interface LoanService {
    int createLoanAccountDetails(Loans loan);
    int updateLoanAccountDetails(Loans loan);
    int deleteLoanAccountDetails(int loanId);
    Loans getLoanAccountDetails(int loanId);
}
