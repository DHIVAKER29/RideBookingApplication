package com.scaler.ridebookingapplication.repository;


import com.scaler.ridebookingapplication.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Implement custom method to find nearest driver
}
