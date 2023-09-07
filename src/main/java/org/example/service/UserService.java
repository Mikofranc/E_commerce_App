package org.example.service;

import org.example.data.model.User;
import org.example.dto.UserRequest;

import java.util.Optional;

public interface UserService {
    void registerNewUser(UserRequest request);
    Optional<User> login(UserRequest request);
}
