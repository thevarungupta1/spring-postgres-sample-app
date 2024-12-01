package com.example.spring.postgre.sample.app.repository;

import com.example.spring.postgre.sample.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
