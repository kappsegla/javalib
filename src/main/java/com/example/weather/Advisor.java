package com.example.weather;

import java.util.Arrays;

public class Advisor {
    static void main() {

        WeatherService service = () -> 0;
        OutfitAdvisor advisor = new OutfitAdvisor(service);
        var result = advisor.getClothingAdvice();
        if( result != null )
            System.out.println(Arrays.toString(result.getBytes()));
    }
}
