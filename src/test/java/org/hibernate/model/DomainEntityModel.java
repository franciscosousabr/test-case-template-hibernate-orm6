package org.hibernate.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DomainEntityModel<ID extends DomainEntityId> {

  @EmbeddedId
  @AttributeOverride(name = "value", column = @Column(name = "id"))
  private final ID id;

  protected DomainEntityModel(ID id) {
    this.id = id;
  }

  public ID getId() {
    return id;
  }
}
