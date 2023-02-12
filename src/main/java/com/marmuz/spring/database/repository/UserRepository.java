package com.marmuz.spring.database.repository;

import com.marmuz.spring.database.pool.ConnectionPool;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final ConnectionPool pool1;

    public UserRepository(ConnectionPool pool1) {
        this.pool1 = pool1;
    }
}
