package com.scaler.ridebookingapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    @Embedded
    private Location pickupLocation;

    @Embedded
    private Location dropoffLocation;

    private float distance;
    private float price;
}
