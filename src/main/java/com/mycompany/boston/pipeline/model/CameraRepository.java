package com.mycompany.boston.pipeline.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "camera", path = "cameras")
public interface CameraRepository extends CrudRepository<Camera, String> {
}
