package com.devsu.banking.person_customer.api;

import com.devsu.banking.person_customer.api.mapper.CustomerDomainMapper;
import com.devsu.banking.person_customer.usecase.customermanagemet.CustomerManagemetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CustomerManagemetUseCase customerManagemetUseCase;
    private final CustomerDomainMapper customerDomainMapper;



    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CreateCustomerCommand.class)
                .map(CreateCustomerCommand::customer)
                .map(customerDomainMapper::toAggregate)
                .flatMap(customerManagemetUseCase::create)
                .flatMap(ServerResponse.ok()::bodyValue);
    }
}
