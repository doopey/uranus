package com.doopey.uranus.service;

import com.doopey.uranus.domain.DotRepository;
import com.doopey.uranus.domain.Task;
import com.doopey.uranus.domain.TaskDotRecord;
import com.doopey.uranus.domain.TaskRepository;
import com.doopey.uranus.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created on 2018/5/25.
 */
@Service
@Transactional
public class DotServiceImpl implements IDotService {

    @Autowired
    DotRepository dotRepository;

    @Autowired
    TaskRepository taskRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(IDotService.class);

    @Override
    public boolean dot(String appId) {
        try {
            Task task = taskRepository.findByAppId(appId).orElse(null);
            if (task == null) {
                LOGGER.error("cannot dot for a task not exists, appId: {}", appId);
                return false;
            }

            String today = DateUtils.today();
            TaskDotRecord taskDotRecord = dotRepository.findByAppIdAndDate(appId, today).orElse(null);
            if (taskDotRecord == null) { // 当天该任务第一次打点
                taskDotRecord = new TaskDotRecord();
                taskDotRecord.setAppId(appId);
                taskDotRecord.setDate(today);
                taskDotRecord.setDotCount(0);
            }
            int dotCount = taskDotRecord.getDotCount();
            dotCount++;
            taskDotRecord.setDotCount(dotCount);
            dotRepository.save(taskDotRecord);
        } catch (Exception e) {
            LOGGER.error("dot exception ", e);
            return false;
        }
        return true;
    }

}
