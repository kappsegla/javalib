package com.example.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceWatcherTest {

    @Mock
    PriceService priceService;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    void sendNotificationWhenPriceLowerThanThreshold() {
        Mockito.when(priceService.getPrice("T-Shirt"))
                .thenReturn(95);

        priceWatcher.checkPrices();

        Mockito.verify(notificationService,
                Mockito.times(1))
                .notify("T-Shirt", 95);
    }


}
