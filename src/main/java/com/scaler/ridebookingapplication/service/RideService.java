package com.scaler.ridebookingapplication.service;


import com.scaler.ridebookingapplication.model.*;
import com.scaler.ridebookingapplication.observer.NotificationService;
import com.scaler.ridebookingapplication.repository.DriverRepository;
import com.scaler.ridebookingapplication.repository.RideRepository;
import com.scaler.ridebookingapplication.repository.UserRepository;
import com.scaler.ridebookingapplication.repository.VehicleRepository;
import com.scaler.ridebookingapplication.strategy.PricingStrategy;
import com.scaler.ridebookingapplication.strategy.PricingStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private NotificationService notificationService;

    public void requestRide(Long userId, String vehicleType, Location pickupLocation) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Vehicle vehicle = vehicleRepository.findByType(vehicleType);

        if (vehicle == null || vehicle.getDriver() == null) {
            notificationService.notifyObservers("No drivers available for vehicle type: " + vehicleType);
            return;
        }

        Driver driver = vehicle.getDriver();

        Ride ride = new Ride(null, user, driver, vehicle, pickupLocation, null, 0, 0);
        rideRepository.save(ride);
        notificationService.notifyObservers("Ride requested successfully for user " + user.getName());
    }

    public void completeRide(Long rideId, Location dropoffLocation, float distance, String vehicleType) {
        Ride ride = rideRepository.findById(rideId).orElseThrow(() -> new IllegalArgumentException("Invalid ride ID"));

        PricingStrategy strategy = PricingStrategyFactory.getPricingStrategy(vehicleType);
        float price = strategy.calculatePrice(distance);

        ride.setDropoffLocation(dropoffLocation);
        ride.setDistance(distance);
        ride.setPrice(price);
        rideRepository.save(ride);

        notificationService.notifyObservers("Ride completed. Total cost: " + price);
    }
}
