package com.spring.boot.jaxrs.configuration;

import com.spring.boot.jaxrs.exception.ExceptionHandler;
import com.spring.boot.jaxrs.resource.UserResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
    }

    @PostConstruct
    public void setUp() {
        register(UserResource.class);
        register(ExceptionHandler.class);
        register(SwaggerSerializers.class);
        register(ApiListingResource.class);
    }
}