package com.java.validation.validationPractice.dto;

import com.java.validation.validationPractice.constraints.DuplicateEmailCheck;
import com.java.validation.validationPractice.validation.groups.UpdateCheck;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentDto {

    @NotBlank(message = "id must not be blank", groups = {UpdateCheck.class}) // this will be checked when update
    private String id;

    @NotBlank(message = "Name must not be blank") // this will be checked always
    private String name;

    @DuplicateEmailCheck(message = "Email already exists")
    @Email(message = "The '${validatedValue}' is not a valid email")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
