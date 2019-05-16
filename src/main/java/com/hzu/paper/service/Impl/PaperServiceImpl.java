package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.CollectionMapper;
import com.hzu.paper.dao.PaperMapper;
import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.Paper;
import com.hzu.paper.service.PaperService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Value("${pythonAddress.address}")
    private String pythonAddress;

    @Value("${pythonAddress.type}")
    private String spiderType;

    /**
     * 通过爬虫获取论文
     * @param userId
     * @param keyWord
     * @return
     */
    @Override
    public Result findPaper(String userId,String keyWord) {

        //获取paper
        List<Paper>papers = new ArrayList<>();
        List<Paper> list = paperMapper.findPaper(keyWord);
        System.out.println(list.size());
        if(list.size()==0){
            //调用爬虫
            paperSpider(keyWord,0);
            list = paperMapper.findPaper(keyWord);

        }
        List<CollectionHistory> collection = collectionMapper.findCollectionByUserId(userId);
        if(CollectionUtils.isNotEmpty(list)){
           for (Paper paper : list){
               for(CollectionHistory collectionHistory : collection){
                   if(collectionHistory.getYhid().equals(userId)&& collectionHistory.getLwid().equals(paper.getLwid())){
                       paper.setIscollect(1);
                   }
               }
               papers.add(paper);
           }
        }
        return new Result(true,StatusCode.OK,"查找成功",papers);
    }

    @Override
    public String findPaperFile(String lwId) {
        String fileName = paperMapper.findPaperFile(lwId);
        return fileName;
    }

    @Override
    public Result findPaperById(String lwid) {
        return new Result(true,StatusCode.OK,"查找成功",paperMapper.selectByPrimaryKey(lwid));
    }

    @Override
    public Result downLoadPaper(String keyWord) {
        int count = paperMapper.hasPaper(keyWord);
        if(count >0){
            //调用爬虫
            paperSpider(keyWord,1);
        }
        return new Result(true,StatusCode.OK,"文件下载成功");
    }

    /**
     * 调用爬虫：可以优化：将url放到数据库然后再查询
     * @param keyWord
     */
    public void paperSpider(String keyWord,int downLoad){
        String a = keyWord;
        try {
            String[] args = new String[] { spiderType, pythonAddress, String.valueOf(a),String.valueOf(downLoad)};
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
