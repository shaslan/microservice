package com.aslan.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Notification {

//    @Id
//    @SequenceGenerator(
//            name = "notification_id_sequence",
//            sequenceName = "notification_id_sequence"
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "notification_id_sequence"
//    )
    private Integer id;
    private String message;
    private String sender;
    private LocalDate sentAt;
    private String toCustomerEmail;
    private Integer toCustomerId;
}
