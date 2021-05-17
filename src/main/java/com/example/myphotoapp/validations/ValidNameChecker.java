package com.example.myphotoapp.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameChecker implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.matches("[a-z A-z .]+"))
        return true;
        else
            return false;
    }
}
