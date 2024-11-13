package com.scaler.ridebookingapplication.repository;


import com.scaler.ridebookingapplication.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
