package com.aula04.banco.banco.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
                                                                        /* length == 2 para nao permitir "@." ou ".@"*/
        if (value == null || !value.contains("@") || !value.contains(".") || value.length() == 2) {
            return true;
        }
        return false;
    }
}
