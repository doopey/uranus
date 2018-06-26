package com.doopey.uranus.service;

import com.doopey.uranus.domain.DotRepository;
import com.doopey.uranus.domain.TaskDotRecord;
import com.doopey.uranus.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2018/5/25.
 */
@Service
@Transactional
public class DotServiceImpl implements IDotService {

    @Autowired
    DotRepository dotRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(IDotService.class);

    @Override
    public boolean dot(String appId) {
        try {
            LOGGER.info("log for test");
            String today = DateUtils.today();
            TaskDotRecord taskDotRecord = dotRepository.findByAppIdAndDate(appId, today).orElse(null);
            if (taskDotRecord == null) {
                LOGGER.info("cannot find task dot record, appId: {}, date: {}", appId, today);
                return false;
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
