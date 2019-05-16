package com.hzu.paper.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PaperVo {
    private String lwid;

    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date lwDate;

    private String lwTitle;

    private String lwAuthor;

    private String file;

    private Integer iscollect;

    private Date createdTime;

    private String lwContent;


}
