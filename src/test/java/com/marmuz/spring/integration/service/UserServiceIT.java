package com.marmuz.spring.integration.service;

import com.marmuz.spring.database.pool.ConnectionPool;
import com.marmuz.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test() {
        System.out.println();

    }
}
