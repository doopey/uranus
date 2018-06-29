package com.doopey.uranus.service;

import com.doopey.uranus.domain.Task;

import java.util.List;

/**
 * Created on 2018/5/24.
 */
public interface ITaskService {

    public Task findOne(String appId);

    public Task save(Task task);

    public List<Task> getAllValidTasks();

    public boolean delete(String appId);

    public boolean pause(String appId);
}

