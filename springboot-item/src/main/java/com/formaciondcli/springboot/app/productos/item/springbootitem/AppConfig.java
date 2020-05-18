package com.formaciondcli.springboot.app.productos.item.springbootitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration

public class AppConfig {
    @Bean(name = "clienteRest")
    @LoadBalanced
    public RestTemplate registratRestTemplate(){
        return new RestTemplate();
    }
}