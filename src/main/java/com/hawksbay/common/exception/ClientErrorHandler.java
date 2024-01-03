package com.hawksbay.common.exception;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.MethodNotAllowedException;
import jakarta.validation.ValidationException;

/**
 * Implementing the interface of ResponseErrorHandler to interrupt RestTemplate custom exceptions.
 */
public class ClientErrorHandler implements ResponseErrorHandler {
  /**
   * Handling the errors when we received 400+ or 500+
   */
  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    HttpStatusCode statusCode = response.getStatusCode();
    if (statusCode.is4xxClientError()) {
      if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
        throw new ValidationException("It's not a valid request");
      } else if (statusCode.equals(HttpStatus.UNAUTHORIZED)) {

      } else if (statusCode.equals(HttpStatus.FORBIDDEN)) {
        throw new PermissionDeniedException("Un authorized to access this");
      } else if (statusCode.equals(HttpStatus.NOT_FOUND)) {
        throw new ResourceNotFoundException("Then provided end point not found");
      } else if (statusCode.equals(HttpStatus.METHOD_NOT_ALLOWED)) {
        throw new MethodNotAllowedException("", null);
      }
      throw new ResourceNotFoundException();
    } else if (statusCode.is5xxServerError()) {
      if (statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {

      } else if (statusCode.equals(HttpStatus.SERVICE_UNAVAILABLE)) {

      } else if (statusCode.equals(HttpStatus.GATEWAY_TIMEOUT)) {

      }
      throw new ResourceNotFoundException();
    } else if (statusCode.isError()) {
      throw new ResourceNotFoundException();
    }

    throw new ResourceNotFoundException(response.getStatusCode().toString());
  }

  /**
   * Checking that does it thrown any error of type 400+ or 500+
   */
  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return response.getStatusCode().is4xxClientError()
        || response.getStatusCode().is5xxServerError() || response.getStatusCode().isError();
  }
}
