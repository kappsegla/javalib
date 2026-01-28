package com.example.price;

public interface NotificationService {
    void notify(String productName, int price);
    boolean isSent();
}
