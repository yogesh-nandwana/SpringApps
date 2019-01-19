package com.na.ewh.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.* ;

public class Godown {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable=false)
  private boolean empty;

  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  private Set<Stack> stacks =new TreeSet<>();

  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  private Address address;

  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  private ContactInfo contactInfo;

  protected Godown() {}

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

  public Set<Stack> getStacks() {
    return stacks;
  }

  public void setStacks(Set<Stack> stacks) {
    this.stacks = stacks;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Godown [id=");
    builder.append(id);
    builder.append(", empty=");
    builder.append(empty);
    builder.append(", stacks=");
    builder.append(stacks);
    builder.append(", address=");
    builder.append(address);
    builder.append(", contactInfo=");
    builder.append(contactInfo);
    builder.append("]");
    return builder.toString();
  }
}