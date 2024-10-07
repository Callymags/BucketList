package com.bucketlist.project.repositories;

import com.bucketlist.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optionally, you can add custom query methods, like finding by username or email
    User findByUserName(String userName);
}
