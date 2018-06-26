package com.doopey.uranus.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/5/24.
 */

@Service
public class IPService {

    private static String ips = new String();

    public String getIPs() {
        return ips;
    }

    public String upload(String newIPs) {
        if (StringUtils.isNotBlank(newIPs)) {
            ips = newIPs;
//            System.out.println("##############" + ips);
        }
        return ips;
    }
}
