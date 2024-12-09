package com.csi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/manager/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file= request.getPart("pic");
        String fileName = file.getSubmittedFileName();
        String path=request.getServletContext().getRealPath("/upload/goods/pic/");
        String dbPath="upload/goods/pic/";
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //获取后缀
        String hz=fileName.substring(fileName.lastIndexOf("."));
        System.out.println(hz);
        //过滤后缀
        if(".jpg".equals(hz)||".png".equals(hz)){
//            new Date().getTime()
            //设置保存的文件名，防止重复
            String nfn= UUID.randomUUID().toString().replace("-","")+hz;
            file.write(path+nfn);
//            System.out.println();
            response.getWriter().write(getServletContext().getContextPath()+"-"+dbPath+nfn);
        }else{
            System.out.println("只能上传以jpg或png结尾的文件");
            response.getWriter().write("false");
        }

    }
}
