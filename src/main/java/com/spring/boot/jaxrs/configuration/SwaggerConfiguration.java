package com.spring.boot.jaxrs.configuration;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public BeanConfig beanConfig() {
        BeanConfig swaggerConfigBean = new BeanConfig();
        swaggerConfigBean.setConfigId("Spring Swagger Jersey Example");
        swaggerConfigBean.setTitle("Rest APIs using JAX-RS, Spring boot, Jersey as Implementation, Swagger");
        swaggerConfigBean.setVersion("v1");
        swaggerConfigBean.setContact("Yogeshkumar Savita");
        swaggerConfigBean.setSchemes(new String[]{"http", "https"});
        swaggerConfigBean.setBasePath("/rest/");
        swaggerConfigBean.setResourcePackage("com.spring.boot.jaxrs.resource");
        swaggerConfigBean.setPrettyPrint(true);
        swaggerConfigBean.setScan(true);
        return swaggerConfigBean;
    }

}
