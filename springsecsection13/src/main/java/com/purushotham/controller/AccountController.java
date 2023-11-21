package com.purushotham.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purushotham.entity.Account;
import com.purushotham.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountsRepository accountsRepository;
    @JsonIgnore
    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam Long id) {
        Account accounts = accountsRepository.findById(id).get();
        return accounts;
    }
}
