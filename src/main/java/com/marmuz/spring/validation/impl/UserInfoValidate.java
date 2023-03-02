package com.marmuz.spring.validation.impl;

import com.marmuz.spring.dto.UserCreateEditDto;
import com.marmuz.spring.validation.UserInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class UserInfoValidate implements ConstraintValidator<UserInfo, UserCreateEditDto> {
    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext context) {

        return hasText(value.getFirstname()) || hasText(value.getLastname());
    }
}
