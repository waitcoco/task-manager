package com.mycompany.boston.pipeline.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Task {
  @Id
  private String id;
  private String videoId;
  private java.sql.Timestamp createTime;
  private long status;
  private String executorId;
  private java.sql.Timestamp executorHeartbeat;
}
