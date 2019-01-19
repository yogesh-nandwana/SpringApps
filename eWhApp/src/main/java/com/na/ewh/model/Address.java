package com.na.ewh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
  
  @Id
  @GeneratedValue
  private int id;
  
  @Column(name="DOOR_NO")
  private String doorNo;
  
  @Column(name="BUILDING_NAME")
  private String buildingName;
  
  private String street;
  
  private String city;
  
  private String state;
  
  private String pincode;
  
  private String country;
  
  @Column(nullable=true)
  private String landmark;
  
  protected Address(){
    //Not exposed for direct use
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDoorNo() {
    return doorNo;
  }

  public void setDoorNo(String doorNo) {
    this.doorNo = doorNo;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }
}