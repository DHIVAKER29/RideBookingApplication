package com.scaler.ridebookingapplication.strategy;

public class HatchbackPricingStrategy implements PricingStrategy {
    @Override
    public float calculatePrice(float distance) {
        return distance * 10;
    }
}