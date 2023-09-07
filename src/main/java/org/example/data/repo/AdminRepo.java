package org.example.data.repo;

import org.example.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, String> {
    Optional<Admin> findByUserName(String username);
}
