package com.hawksbay.common.exception;

/**
 * This exception will be used to thrown when resource was not found.
 */
public class ResourceNotFoundException extends HawksBayException {

  private static final long serialVersionUID = -4861851990361309059L;

  public ResourceNotFoundException() {
    super();
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

}
