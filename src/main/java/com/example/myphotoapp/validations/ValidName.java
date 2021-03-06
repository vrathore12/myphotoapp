package com.example.myphotoapp.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidNameChecker.class)
public @interface ValidName {

    String message() default "This is not a valid name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
