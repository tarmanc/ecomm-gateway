package com.armanc.ecommgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("google")
@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("id",p -> p
                        .path("/googlesearch")
                        .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com")
                )
                .build();
    }


}
