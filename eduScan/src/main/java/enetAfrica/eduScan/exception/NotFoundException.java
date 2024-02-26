package enetAfrica.eduScan.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

  @Getter
  private ErrorCode errorCode;  
  public NotFoundException(String message) {
    super(message);
  } 

  public NotFoundException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

}
