package com.poc.boldconnect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(Application.class);
        LOG.info("Service started successfully.");
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(30000);
//        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(30000);
        //restTemplate.getInterceptors().add(new OutboundHttpRequestInterceptor());
        return restTemplate;
    }

}