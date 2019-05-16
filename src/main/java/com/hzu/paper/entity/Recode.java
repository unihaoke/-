package com.hzu.paper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Recode {
    private Integer id;

    private String yhid;

    @JsonFormat( pattern="yyyy-MM-dd")
    private Date visitDate;

    @JsonFormat( pattern="yyyy-MM-dd")
    private Date visitTimes;

    public Recode(Integer id, String yhid, Date visitDate, Date visitTimes) {
        this.id = id;
        this.yhid = yhid;
        this.visitDate = visitDate;
        this.visitTimes = visitTimes;
    }

    public Recode() {
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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Date visitTimes) {
        this.visitTimes = visitTimes;
    }
}