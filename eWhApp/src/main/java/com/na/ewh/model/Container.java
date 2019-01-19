package com.na.ewh.model;

import javax.persistence.*;

public class Container implements Comparable<Container> {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable=false)
  private boolean empty;

  protected Container() {
    //Not exposed to direct use
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isEmpty() {
    return empty;
  }

  public void setEmpty(boolean empty) {
    this.empty = empty;
  }

  public int compareTo(Container o) {
    return this.getId().compareTo(o.getId());
  }
}