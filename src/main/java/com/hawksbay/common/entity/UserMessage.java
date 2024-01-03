package com.hawksbay.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to send custom message as response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
  private String message;

}
