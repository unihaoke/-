package com.hzu.paper.service;

import com.hzu.paper.common.Result;

public interface PaperService {
    Result findPaper(String userId,String keyWord);

    String findPaperFile(String lwId);

    Result findPaperById(String lwid);

    Result downLoadPaper(String keyWord);
}
