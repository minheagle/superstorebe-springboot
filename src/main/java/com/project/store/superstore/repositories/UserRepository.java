package com.project.store.superstore.repositories;

import com.project.store.superstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByPhone(String phone);
    List<User> findByUserName(String userName);
}
