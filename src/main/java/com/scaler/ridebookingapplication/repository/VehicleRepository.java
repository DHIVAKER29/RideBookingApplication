package com.scaler.ridebookingapplication.repository;


import com.scaler.ridebookingapplication.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByType(String type);
}
