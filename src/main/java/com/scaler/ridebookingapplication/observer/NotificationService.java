package com.scaler.ridebookingapplication.observer;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final List<String> notifications = new ArrayList<>();

    public void notifyObservers(String message) {
        notifications.add(message);
        System.out.println(message);
    }
}

