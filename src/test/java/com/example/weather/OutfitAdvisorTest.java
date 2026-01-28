package com.example.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OutfitAdvisorTest {

    @Mock
    WeatherService weatherService;

    @InjectMocks
    OutfitAdvisor advisor;

    @Test
    void freezingTemps() {
        Mockito.when(weatherService.getTemperature()).thenReturn((float) -5.0);
        String advice = advisor.getClothingAdvice();
        assertThat(advice).isEqualTo("Vinterjacka");
    }
}
