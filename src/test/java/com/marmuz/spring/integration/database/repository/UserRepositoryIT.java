package com.marmuz.spring.integration.database.repository;

import com.marmuz.spring.database.entity.Role;
import com.marmuz.spring.database.repository.UserRepository;
import com.marmuz.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@IT
@RequiredArgsConstructor
class UserRepositoryIT {

    private final UserRepository userRepository;

    @Test
    void checkUpdate() {
        var ivan = userRepository.findById(5L).get();
        assertSame(Role.ADMIN, ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        var resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);


        var theSameIvan = userRepository.findById(5L).get();
        assertSame(Role.USER, theSameIvan.getRole());
    }


    @Test
    void checkQueries() {
        var foundAllUsers = userRepository.findAllBy("a", "ov");
        assertThat(foundAllUsers).hasSize(3);

    }
}