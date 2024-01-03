package com.hawksbay.common.util;

import java.io.File;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for Json, which is used to convert Json to java POJO and vice versa.
 */
@Service
public class JsonUtil {

  @Autowired
  private ObjectMapper objectMapper;

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * Convert json data to Entity
   * 
   * @param jsonObject
   * @param targetClass
   * @return Entity
   * @throws JsonProcessingException
   * @throws JsonMappingException
   * @throws Exception
   */
  public <T> T getEntityFromJson(String jsonObject, Class<T> targetClass)
      throws JsonProcessingException {
    return objectMapper.readValue(jsonObject, targetClass);
  }

  /**
   * Convert Entity object to json string
   * 
   * @param object
   * @return json equivalent data of Entity
   * @throws JsonProcessingException
   * @throws Exception
   */
  public <T> String getJsonFromEntity(T object) throws JsonProcessingException {
    return objectMapper.writeValueAsString(object);
  }

  /**
   * Read file content and convert to entity
   * 
   * @param filePath
   * @param targetClass
   * @return Entity object
   * @throws JsonProcessingException
   * @throws JsonMappingExceptio
   * @throws Exception
   */
  public <T> T getEntityFromFilePath(String filePath, Class<T> targetClass)
      throws JsonProcessingException {
    String jsonObject = getJsonData(filePath);
    if (jsonObject == null) {
      return null;
    }
    return getEntityFromJson(jsonObject, targetClass);
  }

  /**
   * Read file content and returns data
   * 
   * @param path
   * @return jsonContent
   */
  public String getJsonData(String path) {
    File file = null;
    try {
      // Get file from file path
      file = ResourceUtils.getFile(path);
      // Read File Content
      return new String(Files.readAllBytes(file.toPath()));
    } catch (Exception e) {
      logger.error("Exception while converting date to string:{}", e.getMessage());
    }
    return null;
  }
}
