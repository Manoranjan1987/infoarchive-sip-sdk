/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.sip.client.dto.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "operator", "value" })
public class Comparison extends Item {

  private final List<String> value;
  private String name;
  private Operator operator;

  public Comparison() {
    operator = Operator.EQUAL;
    value = new ArrayList<>();
  }

  public Comparison(String name, Operator operator, String value) {
    this(name, operator, Arrays.asList(Objects.requireNonNull(value, "Missing comparison value")));
  }

  public Comparison(String name, Operator operator, List<String> value) {
    this.name = name;
    this.operator = operator;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    Objects.requireNonNull(name);
    this.name = name;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    Objects.requireNonNull(operator);
    this.operator = operator;
  }

  public List<String> getValue() {
    return value;
  }

  public void setValue(List<String> value) {
    Objects.requireNonNull(value);
    this.value.addAll(value);
  }
}
