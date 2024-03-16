package com.java.validation.validationPractice.repository;

import com.java.validation.validationPractice.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,String> {

    StudentEntity findFirstByEmail(String email);

}
