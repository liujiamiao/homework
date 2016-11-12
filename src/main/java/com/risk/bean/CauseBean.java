package com.risk.bean;

import javax.persistence.*;

/**
 * Created by meow on 2016/11/9.
 */
@Entity
@Table(name = "cause")
public class CauseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long risk_id;
    private String name;
    private String description;


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRisk_id() {
        return risk_id;
    }

    public void setRisk_id(long risk_id) {
        this.risk_id = risk_id;
    }
}
