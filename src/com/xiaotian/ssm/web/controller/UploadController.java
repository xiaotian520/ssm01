package com.xiaotian.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class UploadController {

    @RequestMapping("itemspic")
    public void itemspic(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MultipartHttpServletRequest muliRequest = (MultipartHttpServletRequest) request;
        //1.获取图片数据
        MultipartFile mfile = muliRequest.getFile("itemspic1");
        //2.把图片保存在某个路径

        //2.1文件保存的路径
        String uploadFolder = request.getServletContext().getRealPath("/upload");
        System.out.println("uploadFolder"+uploadFolder);
        File uploadFolderFile = new File(uploadFolder);
        if (!uploadFolderFile.exists()){
            uploadFolderFile.mkdirs();
        }

        //2.2文件名
        String suffix = mfile.getOriginalFilename().split("\\.")[1];
        String fileName = UUID.randomUUID().toString() + "." + suffix;
        String totalPath = uploadFolder + "\\" + fileName;
        System.out.println(totalPath);

        //3.文件保存
        FileCopyUtils.copy(mfile.getInputStream(),new FileOutputStream(new File(totalPath)));

        //4.返回数据给客户端
        String imgUrl = "http://localhost:8080//ssm01_war_exploded/upload/" + fileName;
        String responseJson = "{\"imgUrl\":\"" + imgUrl + "\"}";
        response.getWriter().write(responseJson);

    }

}
