package com.doopey.uranus.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created on 2018/5/24.
 */

@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 应用id
     */
    @Id
    @Column(nullable = false)
    private String appId = "";

    /**
     * 应用名称
     */
    @Column(nullable = false, length = 100)
    private String appName = "";

    /**
     * 刷量总数
     */
    @Column(nullable = false)
    private int totalNumber = 0;

    /**
     * 每天刷量
     */
    @Column(nullable = false)
    private int numberPerDay = 0;

    /**
     * 初始下载
     */
    @Column(nullable = false)
    private int initialNumber = 0;

    /**
     * 任务状态
     */
    @Column(nullable = false)
    private int status = 1;

    /**
     * 是否删除
     */
    @Column
    private boolean valid = true;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getNumberPerDay() {
        return numberPerDay;
    }

    public void setNumberPerDay(int numberPerDay) {
        this.numberPerDay = numberPerDay;
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Task{" +
                "appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                ", totalNumber=" + totalNumber +
                ", numberPerDay=" + numberPerDay +
                ", initialNumber=" + initialNumber +
                ", status=" + status +
                ", valid=" + valid +
                '}';
    }

    public ObjectNode toJSONObj() {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("appId", this.appId);
        obj.put("appName", this.appName);
        obj.put("totalNumber", this.totalNumber);
        obj.put("numberPerDay", this.numberPerDay);
        obj.put("initialNumber", this.initialNumber);
        // TODO 把status改为具体描述？
        obj.put("status", this.getStatus());
        return obj;
    }

    public enum TaskStatus {
        RUNNING(1),
        PAUSED(5);

        private int value;

        TaskStatus(int status) {
            this.value = status;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
