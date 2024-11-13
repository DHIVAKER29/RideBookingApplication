package com.scaler.ridebookingapplication.strategy;

public class SuvPricingStrategy implements PricingStrategy {
    @Override
    public float calculatePrice(float distance) {
        return distance * 15;
    }
}