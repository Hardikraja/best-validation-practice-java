package com.java.validation.validationPractice.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.java.validation.validationPractice.constraints.DuplicateEmailCheck.List;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicateEmailCheckValidator.class)
@Documented
@Repeatable(List.class)
public @interface DuplicateEmailCheck {

    String message() default "Duplicate Email Exists!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({FIELD})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        DuplicateEmailCheck[] value();
    }
}
