package com.marmuz.spring.integration.service;

import com.marmuz.spring.config.DatabaseProperties;
import com.marmuz.spring.dto.CompanyReadDto;
import com.marmuz.spring.integration.annotation.IT;
import com.marmuz.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
