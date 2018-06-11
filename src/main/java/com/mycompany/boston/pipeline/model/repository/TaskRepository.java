package com.mycompany.boston.pipeline.model.repository;

import com.mycompany.boston.pipeline.model.Task;
import com.mycompany.boston.pipeline.model.Video;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, String> {


    @Query(value = "select * from task where status = 0 or (status = 1 and executor_heartbeat < '2018-06-09') limit 1", nativeQuery = true)
    Task findAvailableTask();

    Task findbyId(String id);
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE task set status = 1 WHERE id = :taskId",nativeQuery = true)
//    void getTask(@Param("taskId") String taskId, @Param("executorId") String executorId);or (t.status = 1 and TIMESTAMPDIFF(MINUTE,now(),t.executorHeartbeat)>5)
    Video findByVideoId(String videoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE task set status = 2 WHERE id = :taskId and executor_id = :executorId", nativeQuery = true)
    void updateStatus(@Param("taskId") String taskId, @Param("executorId") String executorId);



    @Modifying
    @Transactional
    @Query(value = "UPDATE task set executor_heartbeat = now() WHERE id = :taskId and executor_id = :executorId", nativeQuery = true)
    void updateHeartbeat(@Param("taskId")String taskId, @Param("executorId") String executorId);
}
