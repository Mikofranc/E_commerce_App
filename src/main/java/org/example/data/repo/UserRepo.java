package org.example.data.repo;

import org.example.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, String> {
    Optional<User> findByUserName(String username);
}
