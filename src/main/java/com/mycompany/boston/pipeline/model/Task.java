package com.mycompany.boston.pipeline.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
public class Task {
  @Id
  private String id;
  private String videoId;
  private Instant createTime;
  private long status;
  private String executorId;
  private Instant executorHeartbeat;
}
