package com.devsu.banking.person_customer.model.commons.exceptions.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE)
public enum BusinessErrorMessage {

  INVALID_STATUS("BU_0001", "Status not founded."),
  CUSTOMER_ALREADY_EXIST("BU_0001", "Status not founded."),
  MISSING_REQUIRED_FIELD("PB_0002", "Parameters not found");

  private final String code;
  private final String message;

}
