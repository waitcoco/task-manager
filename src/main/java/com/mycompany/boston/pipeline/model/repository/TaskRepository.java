package com.mycompany.boston.pipeline.model.repository;

import com.mycompany.boston.pipeline.model.Task;
import com.mycompany.boston.pipeline.model.projection.TaskProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, String> {
}
