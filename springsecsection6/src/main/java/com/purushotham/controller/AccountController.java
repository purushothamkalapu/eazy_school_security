package com.purushotham.controller;

import com.purushotham.entity.Account;
import com.purushotham.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam int id) {
        Account accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
