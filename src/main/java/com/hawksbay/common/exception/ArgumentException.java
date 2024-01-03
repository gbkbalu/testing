package com.hawksbay.common.exception;

/**
 * This class is used to throw when user request by providing invalid argument.
 */
public class ArgumentException extends HawksBayException {

  private static final long serialVersionUID = 1L;

  public ArgumentException() {
    super();
  }

  public ArgumentException(String message) {
    super(message);
  }
}
