package com.doopey.uranus.controller;

import com.doopey.uranus.domain.Device;
import com.doopey.uranus.domain.Task;
import com.doopey.uranus.domain.TaskDotRecord;
import com.doopey.uranus.service.IDotService;
import com.doopey.uranus.service.ITaskService;
import com.doopey.uranus.utils.PackResponse;
import com.doopey.uranus.utils.ResponseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2018/5/24.
 */

@RestController
@RequestMapping("/task")
public class TaskController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ITaskService taskService;

    @Autowired
    IDotService dotService;

    @RequestMapping("/add")
    public Object addTask(String appId, String appName,
                        Integer totalNumber, Integer numberPerDay, Integer initialNumber) {
        if (totalNumber == null || numberPerDay == null || initialNumber == null) {
            return ResponseHelper.makeErrorResponse(PackResponse.Result.PARAM_MISSING);
        }
        Task task = new Task();
        task.setAppId(appId);
        task.setAppName(appName);
        task.setTotalNumber(totalNumber);
        task.setNumberPerDay(numberPerDay);
        task.setInitialNumber(initialNumber);
        task = taskService.save(task);
        return ResponseHelper.makeResponse(task.toJSONObj().toString());
    }

    @RequestMapping("")
    public Object getAll() {
        List<Task> tasks = taskService.getAllValidTasks();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Task task : tasks) {
            arrayNode.add(task.toJSONObj());
        }
        return ResponseHelper.makeResponse(arrayNode.toString());
    }

    @RequestMapping("/delete")
    public Object deleteTask(String appId) {
        boolean res = taskService.delete(appId);
        return ResponseHelper.makeResponse(Boolean.toString(res));
    }

    @RequestMapping("/pause")
    public Object pauseTask(String appId) {
        boolean res = taskService.pause(appId);
        return ResponseHelper.makeResponse(Boolean.toString(res));
    }

    @RequestMapping("/dot")
    public Object taskDot(String appId) {
        boolean res = dotService.dot(appId);
        return ResponseHelper.makeResponse(Boolean.toString(res));
    }

    @RequestMapping("/dot/list")
    public Object taskDotList() {
        List<TaskDotRecord> list = dotService.list();
        ArrayNode arrayNode = mapper.createArrayNode();
        for (TaskDotRecord dot : list) {
            arrayNode.add(dot.toJSONObj());
        }
        return ResponseHelper.makeResponse(arrayNode.toString());
    }
}
