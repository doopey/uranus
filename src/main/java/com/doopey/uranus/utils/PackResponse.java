package com.doopey.uranus.utils;

import net.sf.json.JSONObject;

/**
 * Created on 2018/5/25.
 */
public class PackResponse {

    public enum Result {
        OK("ok", 0, "success"),
        ERROR("error", 1001, "error"),
        PARAM_ERROR("error", 1002, "param error"),
        PARAM_MISSING("error", 1003, "param missing");

        private String result = "";
        private int code = 0;
        private String description = "";

        Result(String result, int code, String desc) {
            this.result = result;
            this.code = code;
            this.description = desc;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


    private String result = "ok";
    private int code = 0;
    private String description = "success";
    private Object data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("result", this.result);
        json.put("code", this.code);
        json.put("description", this.description);
        json.put("data", this.data);
        return json;
    }
}
