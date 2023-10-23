package com.project.java.repository;

import com.project.java.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegister, Long> {
}
