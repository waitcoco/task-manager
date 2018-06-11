package com.mycompany.boston.pipeline.controller;

import com.mycompany.boston.pipeline.model.Task;
import com.mycompany.boston.pipeline.model.Video;
import com.mycompany.boston.pipeline.model.repository.TaskRepository;
import lombok.Data;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Data
@Controller
@RequestMapping("api/task")
public class TaskController extends BaseController {
    @Autowired
    private TaskRepository taskRepository;

    @ResponseBody
    @GetMapping(path = "availableTask")
    public Task getAvailableTask(@RequestParam("executorId") String executorId) {
        val task = taskRepository.findAvailableTask();
        return task;
    }
    @ResponseBody
    @PostMapping(path = "completeTask")
    public int completeTask(@RequestParam("taskId") String taskId, @RequestParam("executorId") String executorId) {
        val task = taskRepository.findbyId(taskId);
        if(task != null){
            taskRepository.updateStatus(taskId, executorId);
            return 202;
        }
        else return 400;
    }

    @ResponseBody
    @PostMapping(path = "udpateHeartbeat")
    public int updateHeartbeat(@RequestParam("taskId") String taskId, @RequestParam("executorId") String executorId) {
        val task = taskRepository.findbyId(taskId);
        if(task != null){
            taskRepository.updateHeartbeat(taskId, executorId);
            return 202;
        }
        else return 400;
    }
//    几个问题：
//1. 获取task要保证原子性
//2. completeTask要看更新了几条数据，如果是0条，表示complete失败
//3. updateHeartbeat要看更新了几条数据，如果是0条，表示update失败
//4. 时间需要用数据库的时间，不能用API这边的时间，防止API多实例时时间不同步
}
