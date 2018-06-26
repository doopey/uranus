package com.doopey.uranus.service;

import com.doopey.uranus.domain.Task;
import com.doopey.uranus.domain.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2018/5/24.
 */
@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task findOne(String appId) {
        return taskRepository.findByAppId(appId).orElse(null);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean delete(String appId) {
        Task task = findOne(appId);
        if (task == null) {
            return false;
        }
        task.setValid(false);
        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean pause(String appId) {
        Task task = findOne(appId);
        if (task == null) {
            return false;
        }
        task.setStatus(Task.TaskStatus.PAUSED.getValue());
        taskRepository.save(task);
        return true;
    }

}
