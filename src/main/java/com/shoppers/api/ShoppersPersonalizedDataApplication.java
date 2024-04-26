package com.shoppers.api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppersPersonalizedDataApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShoppersPersonalizedDataApplication.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppersPersonalizedDataApplication.class, args);

    }

    @Bean
    public OpenAPI eventManagerSwagger() {
        final var contact = new Contact();
        var securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic");
        var components = new Components().addSecuritySchemes("HTTP", securityScheme);
        return new OpenAPI().info(new Info().title("Shoppers Personalized Data").version("v1").description("Managing Shoppers Personalized Data").contact(contact.name("Shoppers Personalized Data Dev Team"))).components(components);
    }
}
