package com.hawksbay.common.exception;

/**
 * This is the global/ super RunTime exception in HawksBay application, All the custom exception
 * will extends this exception.
 */
public class HawksBayException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public HawksBayException() {
    super();
  }

  public HawksBayException(String message) {
    super(message);
  }
}
