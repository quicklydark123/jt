package com.jt.service;

import com.jt.util.ImageTypeUtil;
import com.jt.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService {
    @Value("${image.localDir}")
    private String localDir;
    @Value("${image.imageUrl}")
    private String imageUrl;//定义url
    @Autowired
    private ImageTypeUtil imageTypeUtil;


    @Override
    public ImageVO uploadFileToMapper(MultipartFile uploadFile) {
        Set<String> typeSet = imageTypeUtil.getTypeSet();

        String fileName = uploadFile.getOriginalFilename();

        int fileTypeIndex = fileName.lastIndexOf(".");
        String fileType = fileName.substring(fileTypeIndex);
        if (!typeSet.contains(fileType.toLowerCase())) return ImageVO.fail();

        String dateDir = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        String dirPath = dateDir;
        File dirFile = new File(localDir + dirPath);
        if (!dirFile.exists()) dirFile.mkdirs();
        String uuid = UUID.randomUUID().toString();
        String realFileName = uuid + fileType;
        File imageFile = new File(localDir + dirPath + realFileName);
        System.out.println(imageFile.getPath());
        try {
            uploadFile.transferTo(imageFile);
            String url = imageUrl + dateDir + realFileName;
            return ImageVO.successful(url);
        } catch (IOException e) {
            e.printStackTrace();
            return ImageVO.fail();
        }
    }
}
