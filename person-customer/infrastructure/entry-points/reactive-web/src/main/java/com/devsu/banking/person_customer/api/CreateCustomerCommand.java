package com.devsu.banking.person_customer.api;

import com.devsu.banking.person_customer.api.dto.CustomerDTO;

public record CreateCustomerCommand(CustomerDTO customer) {
}
