package com.printshop.config;

import java.io.ByteArrayOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.printshop.service.IPAddressUtil;

@Configuration
public class ClientConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public ByteArrayOutputStream byteArrayOutputStream() {
    	return new ByteArrayOutputStream();
    }
//    @Bean
//    public IPAddressUtil ipaddressutil() {
//    	return new IPAddressUtil();
//    }
}