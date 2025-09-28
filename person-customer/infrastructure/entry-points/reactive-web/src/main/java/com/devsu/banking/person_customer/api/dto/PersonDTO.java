package com.devsu.banking.person_customer.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonDTO {
    private UUID id;
    private String codeId;
    private String name;
    private String genre;
    private Integer age;
    private String address;
    private String telephone;
    private String personId;
}
