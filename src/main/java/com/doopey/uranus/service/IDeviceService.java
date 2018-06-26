package com.doopey.uranus.service;

import com.doopey.uranus.domain.Device;

import java.util.List;

/**
 * Created on 2018/5/25.
 */

public interface IDeviceService {
    public List<Device> getDevices(int start, int end);
}
