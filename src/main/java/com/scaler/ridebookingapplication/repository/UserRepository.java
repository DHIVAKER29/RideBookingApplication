package com.scaler.ridebookingapplication.repository;


import com.scaler.ridebookingapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
