package com.los;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableOAuth2Sso
@EnableScheduling
public class LunchOrderingSystemApplication  extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LunchOrderingSystemApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(appClass);
    }

    private static Class<LunchOrderingSystemApplication> appClass = LunchOrderingSystemApplication.class;

}
