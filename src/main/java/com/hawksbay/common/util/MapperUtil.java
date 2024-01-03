package com.hawksbay.common.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MapperUtil class provides functionality converting from one class object to another class object.
 */
@Service
public class MapperUtil {

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Convert DTO to entity and vice versa
   * 
   * @param object
   * @param targetClass
   * @return
   */
  public <S, T> T convertObject(S sourceObject, Class<T> targetClass) {
    return modelMapper.map(sourceObject, targetClass);
  }

}
