package com.mycompany.boston.pipeline.model.repository;

import com.mycompany.boston.pipeline.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VideoRepository extends CrudRepository<Video, String> {
}
