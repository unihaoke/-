package com.hzu.paper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Paper {
    private String lwid;

    @JsonFormat( pattern="yyyy-MM-dd")
    private Date lwDate;

    private String lwTitle;

    private String lwAuthor;

    private String file;

    private Integer iscollect;

    @JsonFormat( pattern="yyyy-MM-dd")
    private Date createdTime;

    private String lwContent;

    public Paper(String lwid, Date lwDate, String lwTitle, String lwAuthor, String file, Integer iscollect, Date createdTime) {
        this.lwid = lwid;
        this.lwDate = lwDate;
        this.lwTitle = lwTitle;
        this.lwAuthor = lwAuthor;
        this.file = file;
        this.iscollect = iscollect;
        this.createdTime = createdTime;
    }

    public Paper(String lwid, Date lwDate, String lwTitle, String lwAuthor, String file, Integer iscollect, Date createdTime, String lwContent) {
        this.lwid = lwid;
        this.lwDate = lwDate;
        this.lwTitle = lwTitle;
        this.lwAuthor = lwAuthor;
        this.file = file;
        this.iscollect = iscollect;
        this.createdTime = createdTime;
        this.lwContent = lwContent;
    }

    public Paper() {
        super();
    }

    public String getLwid() {
        return lwid;
    }

    public void setLwid(String lwid) {
        this.lwid = lwid == null ? null : lwid.trim();
    }

    public Date getLwDate() {
        return lwDate;
    }

    public void setLwDate(Date lwDate) {
        this.lwDate = lwDate;
    }

    public String getLwTitle() {
        return lwTitle;
    }

    public void setLwTitle(String lwTitle) {
        this.lwTitle = lwTitle == null ? null : lwTitle.trim();
    }

    public String getLwAuthor() {
        return lwAuthor;
    }

    public void setLwAuthor(String lwAuthor) {
        this.lwAuthor = lwAuthor == null ? null : lwAuthor.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getIscollect() {
        return iscollect;
    }

    public void setIscollect(Integer iscollect) {
        this.iscollect = iscollect;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLwContent() {
        return lwContent;
    }

    public void setLwContent(String lwContent) {
        this.lwContent = lwContent == null ? null : lwContent.trim();
    }
}