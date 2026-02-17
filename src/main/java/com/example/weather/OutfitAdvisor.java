package com.example.weather;

import org.jspecify.annotations.Nullable;

public class OutfitAdvisor {

    private final WeatherService weatherService;

    public OutfitAdvisor(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public @Nullable String getClothingAdvice() {
        try {
            var temp = weatherService.getTemperature();
            if (temp < 0)
                return "Vinterjacka";
            if (temp > 15)
                return "T-Shirt";
            return null;
        }catch (IllegalStateException e) {
            return "Jeans and Jacket";
        }
    }
}
