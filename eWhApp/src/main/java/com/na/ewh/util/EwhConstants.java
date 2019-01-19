package com.na.ewh.util;

public class EwhConstants {

  public enum GENDER {
    M("M"), F("F");
    private String gender;

    private GENDER(String gender) {
      this.gender = gender;
    }

    @Override
    public String toString() {
      return (gender.equals("M") ? "Male" : "Female");
    }
  }

  public static enum INITIAL {
    MR("MR"), MRS("MRS"), MISS("MISS");
    private String initial;

    private INITIAL(String initial) {
      this.initial = initial;
    }

    @Override
    public String toString() {
      return initial.equals("MR") ? "Mr" : (initial.equals("MRS") ? "Mrs" : "Miss");
    }
  } 
}