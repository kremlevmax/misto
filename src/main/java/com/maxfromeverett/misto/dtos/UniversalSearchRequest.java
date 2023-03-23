package com.maxfromeverett.misto.dtos;

public class UniversalSearchRequest {
  private String value;
  private Long from;
  private Long to;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
