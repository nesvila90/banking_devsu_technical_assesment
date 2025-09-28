package com.devsu.banking.person_customer.model.customer.gateways;

import com.devsu.banking.person_customer.model.aggregated.CustomerAggregate;
import com.devsu.banking.person_customer.model.customer.Customer;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepository {

    Mono<Customer> create(CustomerAggregate dto);

    Mono<Customer> update(String personId, CustomerAggregate dto);

    Mono<Customer> find(String personId);

    Mono<Void> delete(String personId);
}
