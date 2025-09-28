package com.devsu.banking.person_customer.usecase.customermanagemet;

import com.devsu.banking.person_customer.model.aggregated.CustomerAggregate;
import com.devsu.banking.person_customer.model.customer.Customer;
import com.devsu.banking.person_customer.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class CustomerManagemetUseCase {

    private final CustomerRepository customerRepository;


    public Mono<Customer> create(CustomerAggregate dto) {
        return customerRepository.create(dto).log();
    }

    public Mono<Customer> update(String personId, CustomerAggregate dto) {
        return customerRepository.update(personId, dto);
    }

    public Mono<Customer> find(String personId) {
        return customerRepository.find(personId);
    }

    public Mono<Void> delete(String personId) {
        return customerRepository.delete(personId);
    }
}
