package com.hawksbay.common.exception;

/**
 * This exception will be thrown when user provided invalid keys/ invalid file name which are not
 * exists.
 */
public class InvalidKeyException extends HawksBayException {

  private static final long serialVersionUID = 1L;

  public InvalidKeyException() {
    super();
  }

  public InvalidKeyException(String msg) {
    super(msg);
  }
}
