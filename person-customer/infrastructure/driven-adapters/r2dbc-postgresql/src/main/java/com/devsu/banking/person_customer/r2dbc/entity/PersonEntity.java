package com.devsu.banking.person_customer.r2dbc.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona_entity", schema = "public")
public class PersonEntity {

    @Id
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String genre;
    @Min(18)
    @NotNull
    private Integer age;
    @NotBlank
    private String codeId;
    @NotBlank
    private String address;
    @NotBlank
    private String telephone;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

}

