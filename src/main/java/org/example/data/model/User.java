package org.example.data.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private Roles roles;
    private String password;
    @CreatedDate
    private String createdDate;
}
