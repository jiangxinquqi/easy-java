package com.github.shallwe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Publisher publisher(ApplicationContext applicationContext) {
        Publisher publisher = new Publisher(applicationContext);
        return publisher;
    }

    @Bean
    public TenantCreatedListener tenantCreatedListener() {
        return new TenantCreatedListener();
    }

}
