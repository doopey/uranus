package com.doopey.uranus.service;

import com.doopey.uranus.domain.TaskDotRecord;

import java.util.List;

/**
 * Created on 2018/5/25.
 */
public interface IDotService {

    public boolean dot(String appId);
    public List<TaskDotRecord> list();
}
