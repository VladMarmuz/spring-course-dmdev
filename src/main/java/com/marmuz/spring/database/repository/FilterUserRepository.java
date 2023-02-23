package com.marmuz.spring.database.repository;

import com.marmuz.spring.database.entity.Role;
import com.marmuz.spring.database.entity.User;
import com.marmuz.spring.dto.PersonalInfo;
import com.marmuz.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);
    void updateCompanyAndRoleNamed(List<User> users);
}
