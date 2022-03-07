package com.aula04.banco.banco.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFValidador implements ConstraintValidator<CPF, String> {

    @Override
    public void initialize(CPF constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String cpfSomenteDigitos = value.replace("\\D", "");

        if (cpfSomenteDigitos == null || cpfSomenteDigitos.length() != 11 || cpfSomenteDigitos.equals("00000000000")) {
            return false;
        }
        return true;
    }
}
