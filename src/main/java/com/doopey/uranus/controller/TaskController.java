package com.doopey.uranus.controller;

import com.doopey.uranus.domain.Task;
import com.doopey.uranus.service.IDotService;
import com.doopey.uranus.service.ITaskService;
import com.doopey.uranus.utils.PackResponse;
import com.doopey.uranus.utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/5/24.
 */

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @Autowired
    IDotService dotService;

    @RequestMapping("/test")
    public Task getTaskList() {
        Task task = taskService.findOne("123");
        System.out.println("##########" + task);
        return task;
    }

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
        return ResponseHelper.makeResponse(task.toJSONString());
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
}
