package com.java.validation.validationPractice.service;

import com.java.validation.validationPractice.entity.StudentEntity;

public interface StudentService {

    StudentEntity createStudent(StudentEntity student);

    StudentEntity updateStudent(StudentEntity student);

    StudentEntity getStudentByEmail(String email);

}
