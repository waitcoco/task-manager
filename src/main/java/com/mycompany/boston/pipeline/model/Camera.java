package com.mycompany.boston.pipeline.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Camera {
  @Id
  private String id;
  private String name;
  private double positionLat;
  private double positionLon;
}
