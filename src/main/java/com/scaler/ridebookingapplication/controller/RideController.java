package com.scaler.ridebookingapplication.controller;


import com.scaler.ridebookingapplication.model.Location;
import com.scaler.ridebookingapplication.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @PostMapping("/request")
    public String requestRide(
            @RequestParam Long userId,
            @RequestParam String vehicleType,
            @RequestParam String pickupAddress
    ) {
        Location pickupLocation = new Location(pickupAddress);
        rideService.requestRide(userId, vehicleType, pickupLocation);
        return "Ride requested successfully.";
    }

    @PostMapping("/complete")
    public String completeRide(
            @RequestParam Long rideId,
            @RequestParam String dropoffAddress,
            @RequestParam float distance,
            @RequestParam String vehicleType
    ) {
        Location dropoffLocation = new Location(dropoffAddress);
        rideService.completeRide(rideId, dropoffLocation, distance, vehicleType);
        return "Ride completed successfully.";
    }
}
