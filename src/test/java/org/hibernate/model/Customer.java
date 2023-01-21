package org.hibernate.model;

import jakarta.persistence.Entity;

@Entity
public class Customer extends DomainEntityModel<CustomerId> {

  private Integer code;
  private String name;

  public Customer(Integer code, String name) {
    this();
    this.code = code;
    this.name = name;
  }

  protected Customer() {
    super(new CustomerId());
  }

  public Integer getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
