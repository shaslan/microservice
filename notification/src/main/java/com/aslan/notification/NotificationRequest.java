package com.aslan.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationRequest {
    private String message;
    private String sender;
    private String toCustomerEmail;
    private Integer toCustomerId;
}
