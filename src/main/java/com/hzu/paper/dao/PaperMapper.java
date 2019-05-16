package com.hzu.paper.dao;

import com.hzu.paper.entity.Paper;

import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(String lwid);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(String lwid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKeyWithBLOBs(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> findPaper(String keyWord);

    String findPaperFile(String lwId);

    int hasPaper(String keyWord);
}