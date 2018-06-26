package com.doopey.uranus.utils;

import net.sf.json.JSONObject;

/**
 * Created on 2018/5/24.
 */
public class ResponseHelper {

    public static JSONObject makeResponse(String data) {
        PackResponse res = new PackResponse();
        res.setData(data);
        return res.toJSON();
    }

    public static JSONObject makeErrorResponse(PackResponse.Result result) {
        PackResponse res = new PackResponse();
        res.setResult(result.getResult());
        res.setCode(result.getCode());
        res.setDescription(result.getDescription());
        return res.toJSON();
    }
}
