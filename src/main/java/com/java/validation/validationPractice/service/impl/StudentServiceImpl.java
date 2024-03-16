package com.java.validation.validationPractice.service.impl;

import com.java.validation.validationPractice.entity.StudentEntity;
import com.java.validation.validationPractice.repository.StudentRepository;
import com.java.validation.validationPractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity updateStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity getStudentByEmail(String email) {
        return studentRepository.findFirstByEmail(email);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
