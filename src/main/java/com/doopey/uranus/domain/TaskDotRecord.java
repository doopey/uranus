package com.doopey.uranus.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;

/**
 * Created on 2018/5/25.
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"appId", "date"}))
public class TaskDotRecord {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String appId = "";

    @Column(nullable = false)
    private String date = "";

    @Column(nullable = false)
    private int dotCount = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDotCount() {
        return dotCount;
    }

    public void setDotCount(int dotCount) {
        this.dotCount = dotCount;
    }

    public ObjectNode toJSONObj() {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("appId", this.appId);
        obj.put("date", this.date);
        obj.put("dotCount", this.dotCount);
        return obj;
    }
}
