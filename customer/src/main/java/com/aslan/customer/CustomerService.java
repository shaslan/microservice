package com.aslan.customer;

import com.aslan.clients.fraud.FraudCheckResponse;
import com.aslan.clients.fraud.FraudClient;
import com.aslan.clients.notification.NotificationClient;
import com.aslan.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    @Transactional
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // todo: check if email valid
        // todo: check if email taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        notificationClient.sendNotification(
                new NotificationRequest(
                        "Hello from Aslan",
                        "aslan",
                        customer.getEmail(),
                        customer.getId()
                )
        );
        // todo: send notification
    }
}
