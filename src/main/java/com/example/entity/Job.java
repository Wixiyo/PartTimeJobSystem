package com.example.entity;

import java.util.Date;

public class Job {
    private String busid;
    private String title;
    private String introduction;
    private String requirement;
    private String workDate;
    private int state;
    private String tags;
    private String position;
    private String nums;
    private String salary;

    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getBusid() {
        return busid;
    }
    public void setBusid(String busid) {
        this.busid = busid;
    }
    public void setBid(String bid) {
    }
    public String getWorkDate() {
        return workDate;
    }
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
