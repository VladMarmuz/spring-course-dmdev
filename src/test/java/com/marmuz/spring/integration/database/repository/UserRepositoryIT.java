package com.marmuz.spring.integration.database.repository;

import com.marmuz.spring.database.repository.UserRepository;
import com.marmuz.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
class UserRepositoryIT {

    private final UserRepository userRepository;

    @Test
    void checkQueries() {
        var foundAllUsers = userRepository.findAllBy("a", "ov");
        assertThat(foundAllUsers).hasSize(3);

    }
}