package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * url
     * 参数：File=fileImage
     * 返回值字符串
     */

    /*
     *MultipartFile 接口 主要实现文件接收
     */
    @RequestMapping("/file")
    public String saveFileToService(MultipartFile fileImage) throws IOException {
        String dirPath = "d:/haha";
        File fileDir = new File(dirPath);
        //1.校验是否存在
        if (!fileDir.exists())
            fileDir.mkdirs();
        //3.获取文件信息，一般都上床提交的参数中
        String fileName = fileImage.getOriginalFilename();
        //4.实现文件上传，制定文件真是路径
        File file = new File(dirPath+"/"+fileName);
        //5.利用api实现文件输出
        fileImage.transferTo(file);
        return "恭喜你，文件上传成功";
    }
//    Filename: hah.jpg
//    uploadFile: (binary)
//    Upload: Submit Query
    @PostMapping("/pic/upload")
    public ImageVO uploadFileToService(MultipartFile uploadFile){
        return fileService.uploadFileToMapper(uploadFile);
    }
}
