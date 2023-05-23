package com.maxfromeverett.misto.controller;

import lombok.Data;

@Data
public class SignupRequest {
  private String email;
  private String password;
}
