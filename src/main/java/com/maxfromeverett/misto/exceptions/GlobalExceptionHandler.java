package com.maxfromeverett.misto.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PostNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleNoSuchElementFoundException(PostNotFoundException exception) {
    return buildErrorResponse(exception,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NotEnoughInformationForPostCreationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> handleNotEnoughInfoException(
      NotEnoughInformationForPostCreationException exception) {
    return buildErrorResponse(exception, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Object> handleAllUncaughtException(Exception exception) {
    return buildErrorResponse(exception, "Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<Object> buildErrorResponse(Exception exception,
      HttpStatus httpStatus) {
    return buildErrorResponse(exception, exception.getMessage(), httpStatus);
  }

  private ResponseEntity<Object> buildErrorResponse(Exception exception,
      String message,
      HttpStatus httpStatus) {
    ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
    return ResponseEntity.status(httpStatus).body(errorResponse);
  }
}
