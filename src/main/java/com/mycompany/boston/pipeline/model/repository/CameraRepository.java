package com.mycompany.boston.pipeline.model.repository;

import com.mycompany.boston.pipeline.model.Camera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CameraRepository extends CrudRepository<Camera, String> {
}
