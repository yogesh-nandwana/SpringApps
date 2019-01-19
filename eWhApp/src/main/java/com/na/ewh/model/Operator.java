package com.na.ewh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.na.ewh.util.EwhConstants.GENDER;

@Entity
public class Operator {
  
  @Id
  @GeneratedValue
  private int id;

  @Column(nullable=false,unique=true,updatable=false,name="LOGIN_ID")
  private String loginId;
  
  @Column(name="PWD",nullable=false)
  private char[] password;
  
  @OneToOne
  private ContactInfo contactInfo;
  
  @Enumerated
  private GENDER gender;
  
  protected Operator() {
    //Not exposed for use
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public char[] getPassword() {
    return password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }
  
  
  
}
