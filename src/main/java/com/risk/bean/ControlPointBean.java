package com.risk.bean;

import javax.persistence.*;

/**
 * Created by meow on 2016/11/9.
 */

@Entity
@Table(name = "control_points")
public class ControlPointBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long controlId;
    private long ownerId;
    private String control_point;

    public long getControlId() {
        return controlId;
    }

    public void setControlId(long controlId) {
        this.controlId = controlId;
    }

    public String getControl_point() {
        return control_point;
    }

    public void setControl_point(String control_point) {
        this.control_point = control_point;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
