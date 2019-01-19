package com.na.ewh.model;

import javax.persistence.*;

@Entity
public class Commodity {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable=false,length=10)
  private String name;

  @Enumerated(EnumType.STRING)
  private COMMODITY_TYPE type;

  @Column(nullable=false)
  private float pricePerUnit;

  @Column(nullable=false)
  private float storageChargePerUnit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public COMMODITY_TYPE getType() {
    return type;
  }

  public void setType(COMMODITY_TYPE type) {
    this.type = type;
  }

  public float getPricePerUnit() {
    return pricePerUnit;
  }

  public void setPricePerUnit(float pricePerUnit) {
    this.pricePerUnit = pricePerUnit;
  }

  public float getStorageChargePerUnit() {
    return storageChargePerUnit;
  }

  public void setStorageChargePerUnit(float storageChargePerUnit) {
    this.storageChargePerUnit = storageChargePerUnit;
  }

  protected Commodity() {
    //Not exposed for direct use
  }


  public static enum COMMODITY_TYPE{
    OILY,GRAIN,FRAGILE;

  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Commodity [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", type=");
    builder.append(type);
    builder.append(", pricePerUnit=");
    builder.append(pricePerUnit);
    builder.append(", storageChargePerUnit=");
    builder.append(storageChargePerUnit);
    builder.append("]");
    return builder.toString();
  }
}
