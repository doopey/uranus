package com.doopey.uranus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created on 2018/5/24.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Optional<Task> findByAppId(String appId);

}
