package org.example.service;

import org.example.data.model.Admin;
import org.example.data.model.User;
import org.example.dto.AdminRequest;
import org.example.dto.UserRequest;

import java.util.Optional;

public interface AdminService {
    void registerNewUser(AdminRequest request);
    Admin login(AdminRequest request);
}
