package com.practice.java.users.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id
    @Schema(hidden = true)
    private String id;

    private String name;
    private String email;
    private int age;
    private boolean active;
}
