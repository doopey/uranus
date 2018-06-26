package com.doopey.uranus.controller;

import com.doopey.uranus.domain.Device;
import com.doopey.uranus.service.DeviceServiceImpl;
import com.doopey.uranus.utils.PackResponse;
import com.doopey.uranus.utils.ResponseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2018/5/25.
 */

@RestController
@RequestMapping("/device")
public class DeviceController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    DeviceServiceImpl deviceService;

    /**
     *
     * @param position 起始位置
     * @param num 返回的条数
     * @return
     */
    @RequestMapping("/get")
    public Object get(Integer position, Integer num) {
        if (position == null || num == null) {
            return ResponseHelper.makeErrorResponse(PackResponse.Result.PARAM_MISSING);
        }
        List<Device> devices = deviceService.getDevices(position, num);
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Device device : devices) {
            arrayNode.add(toJsonObject(device));
        }
        return ResponseHelper.makeResponse(arrayNode.toString());
    }

    private ObjectNode toJsonObject(Device device) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("id", device.getId());
        obj.put("info", device.getInfo());
        return obj;
    }
}
