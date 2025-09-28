package com.devsu.banking.person_customer.model.customer;
import com.devsu.banking.person_customer.model.person.Person;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {

    private UUID id;
    private String userId;
    private Person personData;
    private String password;
    private Boolean status;
    private Instant createdAt;
    private Instant updatedAt;
}
