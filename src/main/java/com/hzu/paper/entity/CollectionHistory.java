package com.hzu.paper.entity;

import java.util.Date;

public class CollectionHistory extends CollectionKey {
    private Date createdTime;

    private String lwTitle;

    private String lwAuthor;

    private String lwContent;

    public CollectionHistory(String yhid, String lwid, Date createdTime, String lwTitle, String lwAuthor) {
        super(yhid, lwid);
        this.createdTime = createdTime;
        this.lwTitle = lwTitle;
        this.lwAuthor = lwAuthor;
    }

    public CollectionHistory(String yhid, String lwid, Date createdTime, String lwTitle, String lwAuthor, String lwContent) {
        super(yhid, lwid);
        this.createdTime = createdTime;
        this.lwTitle = lwTitle;
        this.lwAuthor = lwAuthor;
        this.lwContent = lwContent;
    }

    public CollectionHistory() {
        super();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public String getLwContent() {
        return lwContent;
    }

    public void setLwContent(String lwContent) {
        this.lwContent = lwContent == null ? null : lwContent.trim();
    }
}