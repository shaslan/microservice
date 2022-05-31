package com.aslan.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
