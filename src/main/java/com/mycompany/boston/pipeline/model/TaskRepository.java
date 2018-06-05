package com.mycompany.boston.pipeline.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "task", path = "tasks")
public interface TaskRepository extends CrudRepository<Task, String> {
}
