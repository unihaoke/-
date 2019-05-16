package com.hzu.paper.entity;

public class CollectionKey {
    private String yhid;

    private String lwid;

    public CollectionKey(String yhid, String lwid) {
        this.yhid = yhid;
        this.lwid = lwid;
    }

    public CollectionKey() {
        super();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getLwid() {
        return lwid;
    }

    public void setLwid(String lwid) {
        this.lwid = lwid == null ? null : lwid.trim();
    }
}