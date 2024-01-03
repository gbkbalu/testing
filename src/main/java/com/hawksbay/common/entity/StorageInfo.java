package com.hawksbay.common.entity;

import java.io.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used to return file with the name details.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageInfo {
  private String name;
  private File file;
}
