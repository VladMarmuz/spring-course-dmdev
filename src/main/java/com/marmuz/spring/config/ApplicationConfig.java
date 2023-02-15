package com.marmuz.spring.config;

import com.marmuz.spring.database.pool.ConnectionPool;
import com.marmuz.spring.database.repository.UserRepository;
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

    @Bean
    @Profile("prod|web")
//    ! & |
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        var connectionPool1 = pool3();
        var connectionPool2 = pool3();
        var connectionPool3 = pool3();
        return new UserRepository(pool3());
    }
}
