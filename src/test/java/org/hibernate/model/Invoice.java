package org.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice extends DomainEntityModel<InvoiceId> {

  private Integer number;

  @ManyToOne
  private Customer customer;

  public Invoice(Integer number, Customer customer) {
    this();
    this.number = number;
    this.customer = customer;
  }

  protected Invoice() {
    super(new InvoiceId());
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
