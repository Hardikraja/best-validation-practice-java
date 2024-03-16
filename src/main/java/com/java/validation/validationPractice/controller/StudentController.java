package com.java.validation.validationPractice.controller;

import com.java.validation.validationPractice.dto.StudentDto;
import com.java.validation.validationPractice.entity.StudentEntity;
import com.java.validation.validationPractice.service.StudentService;
import com.java.validation.validationPractice.validation.groups.CreateCheck;
import com.java.validation.validationPractice.validation.groups.UpdateCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = "application/json")
    public StudentEntity createStudent(@RequestBody @Validated(CreateCheck.class) StudentDto studentDto){
        StudentEntity studentEntity = dtoToEntity(studentDto);
        return studentService.createStudent(studentEntity);
    }

    private static StudentEntity dtoToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setName(studentDto.getName());
        studentEntity.setEmail(studentDto.getEmail());
        return studentEntity;
    }

    @PutMapping(consumes = "application/json")
    public StudentEntity updateStudent(@RequestBody @Validated(UpdateCheck.class) StudentDto studentDto){
        StudentEntity studentEntity = dtoToEntity(studentDto);
        return studentService.updateStudent(studentEntity);
    }


}
