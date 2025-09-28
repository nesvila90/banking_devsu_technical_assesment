package com.devsu.banking.person_customer.r2dbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
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
@Table(name = "cliente_entity", schema = "public")
public class CustomerEntity {
    @Id
    private UUID id;

    @NotNull
    @Column(unique = true)
    private UUID personId;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private Boolean status = true;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
