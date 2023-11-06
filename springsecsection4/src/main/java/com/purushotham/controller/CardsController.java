package com.purushotham.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String getCarDetails(){
        return  "Here are the cards details from DB";
    }
}
