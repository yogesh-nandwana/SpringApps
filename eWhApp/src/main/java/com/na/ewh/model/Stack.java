package com.na.ewh.model;

import java.util.*;

import javax.persistence.*;

public class Stack implements Comparable<Stack>{
  @Id
  @GeneratedValue
  private Integer id;

  private boolean empty;

  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  Set<Container> containers;

  protected Stack() {
    //Not exposed for direct use
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

  public Set<Container> getContainers() {
    return containers;
  }

  public void setContainers(Set<Container> containers) {
    this.containers = containers;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Stack [id=");
    builder.append(id);
    builder.append(", empty=");
    builder.append(empty);
    builder.append(", containers=");
    builder.append(containers);
    builder.append("]");
    return builder.toString();
  }

  public int compareTo(Stack o) {
    return this.getId().compareTo(o.getId());
  }
}