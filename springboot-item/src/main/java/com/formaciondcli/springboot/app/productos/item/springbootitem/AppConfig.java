package com.formaciondcli.springboot.app.productos.item.springbootitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean(name = "clienteRest")
    public RestTemplate registratRestTemplate(){
        return new RestTemplate();
    }
}