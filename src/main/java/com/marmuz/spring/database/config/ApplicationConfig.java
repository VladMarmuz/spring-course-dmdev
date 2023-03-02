package com.marmuz.spring.database.config;

import com.marmuz.spring.database.pool.ConnectionPool;
import com.marmuz.web.config.WebConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfig {

    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(){
        return new ConnectionPool();
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool();
    }


}
