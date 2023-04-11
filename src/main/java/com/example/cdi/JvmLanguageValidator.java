package com.example.cdi;

import com.example.custom.JvmLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class JvmLanguageValidator implements ConstraintValidator<JvmLanguage, String> {
    private final List<String> favoriteLanguages = Arrays.asList("java","groovy", "kotlin", "scala");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return favoriteLanguages.stream()
                .anyMatch(l -> l.equalsIgnoreCase(value));
    }
}
