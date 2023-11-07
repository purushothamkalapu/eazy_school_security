package com.purushotham.controller;

import com.purushotham.entity.Loan;
import com.purushotham.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestParam int id) {
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDt(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
