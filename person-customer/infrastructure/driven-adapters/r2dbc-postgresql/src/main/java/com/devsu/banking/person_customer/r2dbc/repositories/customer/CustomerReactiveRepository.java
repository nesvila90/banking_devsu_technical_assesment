package com.devsu.banking.person_customer.r2dbc.repositories.customer;

import com.devsu.banking.person_customer.r2dbc.entity.CustomerEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerReactiveRepository extends ReactiveCrudRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM c")
    Mono<CustomerEntity> findByPersonId(String personId);
}
