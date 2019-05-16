package com.hzu.paper.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import com.hzu.paper.common.Result;

import com.hzu.paper.service.PaperService;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@Controller
@RequestMapping(value = "/file")
public class DownLoadFileController {

    @Autowired
    private PaperService paperService;

//    // 获得SpringBoot提供的mongodb的GridFS对象
//    @Autowired
//    private GridFsTemplate gridFsTemplate;
//
//    @Resource
//    private MongoDbFactory mongoDbFactory;

    //实现Spring Boot 的文件下载功能，映射网址为/download
    @GetMapping("/{lwId}/{fileName}")
    public Result downloadFile(@PathVariable String lwId,@PathVariable String fileName, HttpServletResponse response) {
        if(StringUtils.isEmpty(fileName) || StringUtils.isEmpty(lwId)){
            return null;
        }
        String filePath = "/usr/local/file";
        File file = new File(filePath + "/" + fileName);
        System.out.println(file);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + fileName);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    /**
//     * 下载
//     *
//     * @param fileId   文件id
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/downloadFile")
//    public void downloadFile(@RequestParam(name = "file_id") String fileId, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Query query = Query.query(Criteria.where("_id").is(fileId));
//        // 查询单个文件
//        GridFSFile gfsFile = gridFsTemplate.findOne(query);
//        GridFsResource gridFsResource=new GridFsResource(gfsFile,GridFSBuckets.create(mongoDbFactory.getDb()).openDownloadStream(gfsFile.getObjectId()));
//        String fileName = gfsFile.getFilename().replace(",", "");
//        //处理中文文件名乱码
//        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
//                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
//                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
//            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            //非IE浏览器的处理：
//            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//        }
//        // 通知浏览器进行文件下载
//        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
//        IOUtils.copy(gridFsResource.getInputStream(),response.getOutputStream());
//    }

}
