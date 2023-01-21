package org.hibernate.model;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Random;

@MappedSuperclass
public abstract class DomainEntityId implements Serializable {

  private final Long value;

  protected DomainEntityId() {
    Random random = new Random();
    this.value = random.nextLong();
  }

  public Long getValue() {
    return value;
  }
}
