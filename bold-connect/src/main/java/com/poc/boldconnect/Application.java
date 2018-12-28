package com.poc.boldconnect;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
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
        return restTemplate;
    }

    @Bean
    @Primary
    @Scope(value = "singleton")
    public DynamoDB dynamoDB(){

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://dynamodb.us-east-1.amazonaws.com","us-east-1"))
                                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        return dynamoDB;
    }

}