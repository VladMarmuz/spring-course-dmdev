package com.marmuz.spring.integration.database.repository;

import com.marmuz.spring.database.entity.Role;
import com.marmuz.spring.database.entity.User;
import com.marmuz.spring.database.repository.UserRepository;
import com.marmuz.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryIT {

    private final UserRepository userRepository;

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(0, 2, Sort.by("id"));
        var page = userRepository.findAllBy(pageable);
        assertThat(page).hasSize(2);
        page.forEach(user -> System.out.println(user.getCompany().getName()));
        while (page.hasNext()) {
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }

    @Test
    void checkSort() {
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getFirstname)
                .and(sortBy.by(User::getLastname));

        var id = Sort.by("firstname").and(Sort.by("lastname"));
        var users = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(users).hasSize(3);

    }

    @Test
    void checkFirstTop() {
        var foundUser = userRepository.findFirstByOrderByIdDesc();
        assertTrue(foundUser.isPresent());
        foundUser.ifPresent(user -> assertEquals(5L, user.getId()));

    }

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