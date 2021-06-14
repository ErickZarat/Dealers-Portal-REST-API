package me.erickzarat.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInformation());
    }

    private ApiInfo getApiInformation(){
        return new ApiInfo("Dealers Rest Api Documentation",
                "This Rest Api was created with Spring Boot",
                "1.0",
                "API Terms of Service URL",
                new Contact("Erick Zarat", "erickzarat.me", "ezarat15@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
        );
    }
}
