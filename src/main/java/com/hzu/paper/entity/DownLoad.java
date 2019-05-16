package com.hzu.paper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DownLoad {
    private Integer id;

    private String yhid;

    private String lwid;

    @JsonFormat( pattern="yyyy-MM-dd")
    private Date downDate;

    private String title;

    public DownLoad(Integer id, String yhid, String lwid, Date downDate, String title) {
        this.id = id;
        this.yhid = yhid;
        this.lwid = lwid;
        this.downDate = downDate;
        this.title = title;
    }

    public DownLoad() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDownDate() {
        return downDate;
    }

    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}