package com.mycompany.boston.pipeline.controller;

import com.mycompany.boston.pipeline.model.Task;
import com.mycompany.boston.pipeline.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
@RequestMapping("api/task")
public class TaskController extends BaseController {
    @Autowired
    private TaskRepository taskRepository;

    @ResponseBody
    @GetMapping(path = "availableTask")
    public Task getAvailableTask(@RequestParam("executorId") String executorId) {
        Task task = taskRepository.findFirstByExecutorHeartbeatLessThanOrStatusEquals(Instant.now().minusSeconds(60 * 5), 0);
        if (task != null) {
            task.setStatus(1);
            task.setExecutorHeartbeat(Instant.now());
            task.setExecutorId(executorId);
            taskRepository.save(task);
        }
        return task;
    }

    @ResponseBody
    @PostMapping(path = "completeTask")
    public void completeTask(@RequestParam("taskId") String taskId, @RequestParam("executorId") String executorId) {
        taskRepository.updateStatus(taskId, executorId, 2);
    }

    @ResponseBody
    @PostMapping(path = "udpateHeartbeat")
    public void updateHeartbeat(@RequestParam("taskId") String taskId, @RequestParam("executorId") String executorId) {
        taskRepository.updateHeartbeat(taskId, executorId, Instant.now());
    }
}
