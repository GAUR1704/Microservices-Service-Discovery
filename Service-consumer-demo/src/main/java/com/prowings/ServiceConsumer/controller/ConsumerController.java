package com.prowings.ServiceConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.ServiceConsumer.service.ServiceProviderClient;



@RestController
public class ConsumerController {
    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @GetMapping("/consume")
    public String consumeHello() {
        return serviceProviderClient.getHello();
    }
}
