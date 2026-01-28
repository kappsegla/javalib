package com.example.price;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

@ExtendWith(MockitoExtension.class)
public class PriceWatcherAsyncTest {

    @Mock
    PriceService priceService;

    @Spy
    NotificationService notificationService = new AsyncNotificationService();

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    void sendNotificationWhenPriceLowerThanThreshold() throws InterruptedException {
        Mockito.when(priceService.getPrice("T-Shirt"))
                .thenReturn(95);

        priceWatcher.checkPrices();

        Awaitility.await().atMost(5, TimeUnit.SECONDS)
                .pollDelay(500, TimeUnit.MILLISECONDS)
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .until(notificationService::isSent);
    }
}
