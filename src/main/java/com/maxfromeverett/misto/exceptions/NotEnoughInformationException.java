package com.maxfromeverett.misto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughInformationException extends RuntimeException {

  public NotEnoughInformationException(String message) {
    super(message);
  }
}
