package com.risk.bean;

/**
 * Created by meow on 2016/11/9.
 */
public class CauseBean {
    private long risk_id;
    private String name;
    private String description;

    public long getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(long risk_id) {
        this.risk_id = risk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
