package com.risk.bean;

/**
 * Created by meow on 2016/11/9.
 */
public class ControlPointBean {
    private long control_id;
    private String control_point;
    private long risk_id;

    public long getControl_id() {
        return control_id;
    }

    public void setControl_id(long control_id) {
        this.control_id = control_id;
    }

    public String getControl_point() {
        return control_point;
    }

    public void setControl_point(String control_point) {
        this.control_point = control_point;
    }

    public long getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(long risk_id) {
        this.risk_id = risk_id;
    }
}