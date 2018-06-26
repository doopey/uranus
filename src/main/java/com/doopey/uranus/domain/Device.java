package com.doopey.uranus.domain;

import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.persistence.*;

/**
 * Created on 2018/5/25.
 */
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 2000)
    private String info = "";

    @Column(nullable = false, columnDefinition = "bit(1) default 1")
    private boolean valid = true;

    public long getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
