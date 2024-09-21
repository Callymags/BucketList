package com.bucketlist.project.users.microservice.repository;

import com.bucketlist.project.users.microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Any custom queries if necessary
}