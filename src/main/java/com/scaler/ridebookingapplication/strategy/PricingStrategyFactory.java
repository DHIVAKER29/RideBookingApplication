package com.scaler.ridebookingapplication.strategy;

public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategy(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "sedan" -> new SedanPricingStrategy();
            case "suv" -> new SuvPricingStrategy();
            case "hatchback" -> new HatchbackPricingStrategy();
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
    }
}
