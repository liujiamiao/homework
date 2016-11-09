package com.risk.bean;

/**
 * Created by meow on 2016/11/9.
 */
public class RiskBean {
    private long id;
    private String title;
    private String description;
    private int level;
    private int possibility;
    private long submitter_id;
    private long tracker_id;
    private int state;
    private long timestamp;
    private int threshold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPossibility() {
        return possibility;
    }

    public void setPossibility(int possibility) {
        this.possibility = possibility;
    }

    public long getSubmitter_id() {
        return submitter_id;
    }

    public void setSubmitter_id(long submitter_id) {
        this.submitter_id = submitter_id;
    }

    public long getTracker_id() {
        return tracker_id;
    }

    public void setTracker_id(long tracker_id) {
        this.tracker_id = tracker_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
