package com.lukestas.agg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
@RequestMapping("api/health")
public class APIStatusController {

    @GetMapping
    public String getMethodName() {
        return "API WORKING";
    }

}
