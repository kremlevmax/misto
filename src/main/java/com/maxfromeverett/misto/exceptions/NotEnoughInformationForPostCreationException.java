package com.maxfromeverett.misto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughInformationForPostCreationException extends RuntimeException {

  public NotEnoughInformationForPostCreationException(String message) {
    super(message);
  }
}
