package com.mycompany.boston.pipeline.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
public class Video {
  @Id
  private String id;
  private String cameraId;
  private String originalLocation;
  private String playbackUrl;
  private Instant startTime;
}
