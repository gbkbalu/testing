package com.hawksbay.common.exception;

/**
 * This exception will used to thrown when user has not enough permission to access any
 * api/resources(authorization).
 */
public class PermissionDeniedException extends HawksBayException {

  private static final long serialVersionUID = 1L;

  public PermissionDeniedException() {
    super();
  }

  public PermissionDeniedException(String message) {
    super(message);
  }
}
