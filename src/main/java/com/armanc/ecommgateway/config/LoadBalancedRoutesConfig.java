package com.armanc.ecommgateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@Configuration
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("test", p -> p
                        .path("/api/v1/items", "/api/v1/item/*", "/api/v1/search*")
                        .uri("lb://test")
                        //lb = load balance, service-name=spring.application.name
                )
                .build();
    }

}
