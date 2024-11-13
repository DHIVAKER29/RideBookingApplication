package com.scaler.ridebookingapplication.strategy;

public class SedanPricingStrategy implements PricingStrategy {
    @Override
    public float calculatePrice(float distance) {
        return distance * 12;
    }
}
