package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.model.Roles;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private Roles roles;
    private  String password;
}
