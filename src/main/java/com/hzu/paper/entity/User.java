package com.hzu.paper.entity;

public class User {
    private String yhid;

    private String userName;

    public User(String yhid, String userName) {
        this.yhid = yhid;
        this.userName = userName;
    }

    public User() {
        super();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}