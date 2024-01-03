package com.hawksbay.common.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Bean configurations of ObjectMapper, ModelMapper, RestTemplate
 */
@Configuration
public class HakwsBayConfig {
  /**
   * Creating ObjectMapper bean reuse
   * 
   * @return ObjectMapper
   */
  @Bean
  ObjectMapper getObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper;
  }

  /**
   * Creating ModelMapper object
   * 
   * @return ModelMapper
   */
  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  /**
   * Creating RestTemplate object
   * 
   * @return RestTemplate
   */
  @Bean
  RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
