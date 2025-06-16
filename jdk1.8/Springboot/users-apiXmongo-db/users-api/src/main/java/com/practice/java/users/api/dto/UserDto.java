package com.practice.java.users.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Document(collection = "users")
public class UserDto {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Min(value = 18, message = "Minimal age allowed is 18 years old")
    private int age;
    private boolean active;
}
