package com.devsu.banking.person_customer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomerDTO {

    private UUID id;
    private String userId;
    private PersonDTO personData;
    private String password;
    private Boolean status;
    private Instant createdAt;
    private Instant updatedAt;
}
