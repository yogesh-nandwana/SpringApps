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

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "MIDDLE_NAME")
  private String middleName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "BIRTH_DATE")
  private Date dob;

  @Column(name = "PARENT_NAME")
  private String parentName;

  @OneToOne
  private ContactInfo contactInfo;

  @OneToOne
  private Address address;

  protected Customer() {
    // Not exposed for direct use
  }

  public static enum CUSTOMER_TYPE {
    F("F"), T("T");

    private String customerType;

    private CUSTOMER_TYPE(String customerType) {
      this.customerType = customerType;
    }

    @Override
    public String toString() {
      return customerType.equals("F") ? "Farmer" : "Trader";
    }
  }
}