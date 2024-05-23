package com.prowings.ServiceConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Service-provider-demo")
public interface ServiceProviderClient {
    @GetMapping("/hello")
    String getHello();
}
