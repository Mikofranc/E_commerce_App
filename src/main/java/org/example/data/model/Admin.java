package org.example.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
public class Admin {
    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private Roles roles;
    private String password;
    @CreatedDate
    private String createdDate;
}
