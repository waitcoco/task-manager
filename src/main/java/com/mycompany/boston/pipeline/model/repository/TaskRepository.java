package com.mycompany.boston.pipeline.model.repository;

import com.mycompany.boston.pipeline.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, String> {
    Task findFirstByExecutorHeartbeatLessThanOrStatusEquals(Instant executorHeartbeat, long status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE task set status = :status WHERE id = :taskId and executor_id = :executorId", nativeQuery = true)
    void updateStatus(@Param("taskId") String taskId, @Param("executorId") String executorId, @Param("status") long status);


    @Modifying
    @Transactional
    @Query(value = "UPDATE task set executor_heartbeat = :executorHeartbeat WHERE id = :taskId and executor_id = :executorId", nativeQuery = true)
    void updateHeartbeat(@Param("taskId") String taskId, @Param("executorId") String executorId, @Param("executorHeartbeat") Instant executorHeartbeat);
}
