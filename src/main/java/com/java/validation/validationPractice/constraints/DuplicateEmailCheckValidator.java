package com.java.validation.validationPractice.constraints;

import com.java.validation.validationPractice.service.StudentService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DuplicateEmailCheckValidator implements ConstraintValidator<DuplicateEmailCheck,String> {


    @Autowired
    StudentService studentService;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        return studentService.getStudentByEmail(value) == null;
    }
}
