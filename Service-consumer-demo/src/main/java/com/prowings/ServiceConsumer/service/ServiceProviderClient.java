package com.prowings.ServiceConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider")
public interface ServiceProviderClient {
    @GetMapping("/hello")
    String getHello();
}
