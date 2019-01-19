package com.na.ewh.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
  
  @Id
  @GeneratedValue
  private int id;
  
  @Column(name="FIRST_NAME")
  private String firstName;
  
  @Column(name="MIDDLE_NAME")
  private String middleName;
  
  @Column(name="LAST_NAME")
  private String lastName;
  
  @Column(name="BIRTH_DATE")
  private Date dob;
  
  @Column(name="PARENT_NAME")
  private String parentName;
  
  @OneToOne
  private Address address;
  
  protected Customer(){
    //Not exposed for direct use
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}