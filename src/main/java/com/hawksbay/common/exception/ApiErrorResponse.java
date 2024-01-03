package com.hawksbay.common.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to send response with as ApiErrorResponse object with code, message, details
 * and time.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
  private int errorCode;
  private String message;
  private String details;
  private LocalDateTime createdAt;

  public ApiErrorResponse(int code, String msg, String det) {
    this.errorCode = code;
    this.message = msg;
    this.details = det;
    this.createdAt = LocalDateTime.now();

  }
}
