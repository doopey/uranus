package com.doopey.uranus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2018/5/25.
 */
public interface DotRepository extends JpaRepository<TaskDotRecord, Long> {
    public Optional<TaskDotRecord> findByAppIdAndDate(String appId, String date);
    public List<TaskDotRecord> findAll();
}
