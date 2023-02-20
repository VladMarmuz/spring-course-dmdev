package com.marmuz.spring.database.repository;

import com.marmuz.spring.database.entity.User;
import com.marmuz.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
