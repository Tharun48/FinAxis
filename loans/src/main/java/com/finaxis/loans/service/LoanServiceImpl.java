package com.finaxis.loans.service;

import com.finaxis.loans.LoansApplication;
import com.finaxis.loans.model.Loans;
import com.finaxis.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;

    @Autowired
    LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public int createLoanAccountDetails(Loans loan) {
        Loans savedLoan = loanRepository.save(loan);
        return savedLoan.getLoanId();
    }

    @Override
    public int updateLoanAccountDetails(Loans loan) {
        Loans savedLoan = loanRepository.save(loan);
        return savedLoan.getLoanId();
    }

    @Override
    public int deleteLoanAccountDetails(int loanId) {
        Loans loans = getLoanAccountDetails(loanId);
        loanRepository.delete(loans);
        return loanId;
    }

    @Override
    public Loans getLoanAccountDetails(int loanId) {
        return loanRepository.findByLoanId(loanId);
    }
}
