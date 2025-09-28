package com.devsu.banking.person_customer.api.mapper;

import com.devsu.banking.person_customer.api.CreateCustomerCommand;
import com.devsu.banking.person_customer.api.dto.CustomerDTO;
import com.devsu.banking.person_customer.api.dto.PersonDTO;
import com.devsu.banking.person_customer.model.aggregated.CustomerAggregate;
import com.devsu.banking.person_customer.model.customer.Customer;
import com.devsu.banking.person_customer.model.person.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerDomainMapper {


    @Mapping(target = "customer", source = ".")
    CustomerAggregate toAggregate(CustomerDTO entity);

//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    @Mapping(target= "id", ignore = true)
//    @Mapping(source = "customer.userId", target = "userId")
//    @Mapping(source = "customer.password", target = "password")
//    @Mapping(source = "customer.personData", target = "personData")
//    Customer toDomain(CreateCustomerCommand entity);

    @Mapping(target = "id", ignore = true)
    Person personDTOToPerson(PersonDTO personDTO);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(source = "personData.personId", target = "personId")
//    @Mapping(source = "personData.age", target = "age")
//    @Mapping(source = "personData.name", target = "name")
//    @Mapping(source = "personData.genre", target = "genre")
//    @Mapping(source = "personData.address", target = "address")
//    @Mapping(source = "personData.telephone", target = "telephone")
//    Person customerDTOToPerson(CustomerDTO customerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "personData", source = "personData")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "status", source = "status")
    Customer toDomain(CustomerDTO customerDTO);





}
