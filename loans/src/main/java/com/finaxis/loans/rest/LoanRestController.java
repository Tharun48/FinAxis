package com.finaxis.loans.rest;

import com.finaxis.loans.model.Loans;
import com.finaxis.loans.service.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="loans")
public class LoanRestController {

    LoanService loanService;
    @Autowired
    LoanRestController(LoanService loanService){
        this.loanService=loanService;
    }

    @PostMapping("/loans")
    public int createLoanAccountDetails(Loans loan) {
        return loanService.createLoanAccountDetails(loan);
    }

    @PutMapping("/loans")
    public int updateLoanAccountDetails(Loans loan) {
        return loanService.updateLoanAccountDetails(loan);
    }

    @DeleteMapping("/loans/{loanId}")
    public int deleteLoanAccountDetails(int loanId) {
        return loanService.deleteLoanAccountDetails(loanId);
    }

    @GetMapping("/loans/{loanId}")
    public Loans getLoanAccountDetails(@PathVariable int loanId) {
        return loanService.getLoanAccountDetails(loanId);
    }

}
