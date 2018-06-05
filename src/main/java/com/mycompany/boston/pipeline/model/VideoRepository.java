package com.mycompany.boston.pipeline.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "video", path = "videos")
public interface VideoRepository extends CrudRepository<Video, String> {
}
