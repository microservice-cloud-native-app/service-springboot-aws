package com.poc.boldconnect.config;

import static springfox.documentation.builders.PathSelectors.regex;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev1","dev2","dev3","default"})
public class SwaggerApiDocumentationConfiguration {

    public static final String BASE_PACKAGE = "com.poc.boldconnect";
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("BOLD API")
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }

    @Bean
    public UiConfiguration uiConfig() {
      return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
      return new ApiInfoBuilder()
        .title("Bold Connect API")
        .build();
    }
}