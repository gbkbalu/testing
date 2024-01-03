package com.hawksbay.common.exception;

import java.nio.file.AccessDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

/**
 * RestControllerAdvice will receive exception when it was thrown from controller in the
 * application.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * Which is used to thrown when validation fails.
   * 
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {ConstraintViolationException.class, ValidationException.class,
      MissingServletRequestParameterException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ApiErrorResponse> constraintViolationException(Exception ex) {
    logMessage(ex);
    return new ResponseEntity<ApiErrorResponse>(
        new ApiErrorResponse(400, "Bad Request", ex.getMessage()), HttpStatus.BAD_REQUEST);

  }

  /**
   * Which is used to thrown when searching thing was not found.
   * 
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {NoHandlerFoundException.class, ResourceNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiErrorResponse> noHandlerFoundException(Exception ex) {
    logMessage(ex);
    return new ResponseEntity<ApiErrorResponse>(
        new ApiErrorResponse(404, "Resource Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  /**
   * Which is used to thrown when user trying to access which he doesn't have enough permissions to
   * access it.
   * 
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity<ApiErrorResponse> accessDeniedException(Exception ex) {
    logMessage(ex);
    return new ResponseEntity<ApiErrorResponse>(
        new ApiErrorResponse(403, "Access denied exception", ex.getMessage()),
        HttpStatus.FORBIDDEN);
  }

  /**
   * Which is used to thrown when we received Internal server error of 500 type exception
   * 
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ApiErrorResponse> unknownException(Exception ex) {
    logMessage(ex);
    return new ResponseEntity<ApiErrorResponse>(
        new ApiErrorResponse(500, "Internal Server Error", ex.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Which is used to log the message by using logger.
   * 
   * @param ex
   */
  public void logMessage(Exception ex) {
    ex.printStackTrace();
    logger.error("Error in, Global exception handler:{}", ex.getMessage(), ex.getCause());
  }
}
