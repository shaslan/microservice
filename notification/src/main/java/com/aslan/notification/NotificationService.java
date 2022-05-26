package com.aslan.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    public void registerNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .toCustomerId(notificationRequest.getToCustomerId())
                .sentAt(LocalDate.now())
                .build();

        notificationRepository.save(notification);
    }
}
