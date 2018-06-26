package com.doopey.uranus.controller;

import com.doopey.uranus.service.IPService;
import com.doopey.uranus.utils.PackResponse;
import com.doopey.uranus.utils.ResponseHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/5/24.
 */

@RestController
@RequestMapping("/ip")
public class IPController {

    @Autowired
    IPService ipService;

    @RequestMapping("/upload")
    public Object upload(String ip) {
        if (StringUtils.isBlank(ip)) {
            return ResponseHelper.makeErrorResponse(PackResponse.Result.PARAM_MISSING);
        }
        return ResponseHelper.makeResponse(ipService.upload(ip));
    }

    @RequestMapping("/get")
    public Object get() {
        return ResponseHelper.makeResponse(ipService.getIPs());
    }
}
