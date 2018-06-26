package com.doopey.uranus.service;

import com.doopey.uranus.domain.Device;
import com.doopey.uranus.domain.DeviceRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2018/5/25.
 */
@Service
@Transactional
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    /**
     * 如果start+limit超过最大长度了，需要从头再读
     * @param start
     * @param limit
     * @return
     */
    @Override
    public List<Device> getDevices(int start, int limit) {
        int totalNum = (int) deviceRepository.count();
        List<Device> result = Lists.newArrayList();
        while (start + limit - 1 > totalNum) {
            result.addAll(deviceRepository.findDevicesByValidTrueAndIdBetween(start, totalNum));
            limit -= totalNum - start + 1;
            start = 1;
        }
        result.addAll(deviceRepository.findDevicesByValidTrueAndIdBetween(start, limit + start - 1));
        return result;
    }

    public static void main(String[] args) {
        int start = 2;
        int limit = 6;
        int totalNum = 3;
        while (start + limit - 1 > totalNum) {
            System.out.println(String.format("while between %d and %d", start, totalNum));
            limit -= totalNum - start + 1;
            start = 1;
        }
        System.out.println(String.format("while between %d and %d", start, limit + start - 1));
    }

}
