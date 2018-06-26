package com.doopey.uranus.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2018/5/25.
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {

    public List<Device> findDevicesByValidTrueAndIdBetween(long start, long end);
}
