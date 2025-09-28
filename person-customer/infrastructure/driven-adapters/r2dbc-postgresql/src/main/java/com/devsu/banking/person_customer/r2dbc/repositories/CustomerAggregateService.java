package com.devsu.banking.person_customer.r2dbc.repositories;

import com.devsu.banking.person_customer.model.aggregated.CustomerAggregate;
import com.devsu.banking.person_customer.model.customer.Customer;
import com.devsu.banking.person_customer.model.customer.gateways.CustomerRepository;
import com.devsu.banking.person_customer.r2dbc.mapper.CustomerMapper;
import com.devsu.banking.person_customer.r2dbc.mapper.PersonMapper;
import com.devsu.banking.person_customer.r2dbc.repositories.customer.CustomerReactiveRepository;
import com.devsu.banking.person_customer.r2dbc.repositories.person.PersonReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomerAggregateService implements CustomerRepository {


    private final PersonReactiveRepository personRepo;
    private final CustomerReactiveRepository customerRepo;
    private final TransactionalOperator rxtx;
    private final ObjectMapper mapper;
    private final PersonMapper personMapper;
    private final CustomerMapper customerMapper;

    // CREATE en cascada
    @Override
    public Mono<Customer> create(CustomerAggregate dto) {
        var person = personMapper.toModel(dto.customer().getPersonData());
        var customer = customerMapper.toModel(dto.customer());
        return personRepo.save(person)
                .flatMap(savedPerson -> {
                    customer.setPersonId(savedPerson.getId());
                    return customerRepo.save(customer)
                            .map(savedCustomer -> customerMapper.toModel(savedCustomer, savedPerson));
                })
                .as(rxtx::transactional);
    }

    /**
     * UPDATE: merge con ObjectMapper, transacción única
     */
    @Override
    public Mono<Customer> update(String codeId, CustomerAggregate dto) {
        return Mono.zip(
                        personRepo.findByCodeId(codeId),
                        customerRepo.findByPersonId(dto.customer().getUserId())
                )
                .flatMap(tuple -> {
                    var person = tuple.getT1();
                    var customer = tuple.getT2();
                    customerMapper.partialUpdate(dto.customer(), customer);
                    personMapper.partialUpdate(dto.customer().getPersonData(), person);
                    return Mono.zip(personRepo.save(person), customerRepo.save(customer))
                            .map(t -> customerMapper.toModel(t.getT2(), t.getT1()));
                }).as(rxtx::transactional);
    }

    @Override
    public Mono<Customer> find(String codeId) {
        return
                personRepo.findByCodeId(codeId)
                        .flatMap(personEntity -> customerRepo.findByPersonId(codeId)
                                .map(customerEntity -> customerMapper.toModel(customerEntity, personEntity)));
    }

    @Override
    public Mono<Void> delete(String personId) {
        return customerRepo.findByPersonId(personId)
                .flatMap(c -> customerRepo.deleteById(c.getId()))
                //.then( personRepo.deleteByPersonId(personId))
                .as(rxtx::transactional);
    }
}
