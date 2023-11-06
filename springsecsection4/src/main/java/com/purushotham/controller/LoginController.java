package com.purushotham.controller;

import com.purushotham.entity.CustomerEntity;
import com.purushotham.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerEntity customerEntity){
        CustomerEntity savedCustomer = null;
        ResponseEntity response = null;
        try {
            String passwordEncoded = passwordEncoder.encode(customerEntity.getPwd());
            customerEntity.setPwd(passwordEncoded);
            savedCustomer = customerRepository.save(customerEntity);

            if(savedCustomer.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are saved successfully registered...");
            }
        }catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to "+e.getMessage());
        }
        return response;
    }
}
