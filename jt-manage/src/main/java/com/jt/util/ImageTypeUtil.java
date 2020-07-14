package com.jt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashSet;
import java.util.Set;

@Component
@PropertySource("classpath:/properties/image.properties")
public class ImageTypeUtil {
    //private static Set<String> typeSet = new HashSet<String>();

    /**
     * 一般图片属性
     */
//    static {
//        typeSet.add(".jpg");
//        typeSet.add(".gif");
//        typeSet.add(".png");
//        typeSet.add(".jpeg");
//        typeSet.add(".bmp");
//    }
//
//    public static Set<String> getTypeSet(){
//
//        return typeSet;
//    }

    //可以利用Spring容器动态为属性赋值
    @Value("${image.imageTypes}")
    private String imageTypes;
    private Set<String> typeSet = new HashSet<String>();

    //初始化信息
    @PreDestroy// spring容器关闭后执行该方法
    @PostConstruct//当前对象交给容器管理后,执行该方法
    public void init() {
        String[] typesArray = imageTypes.split(",");
        for (String imagetype : typesArray) {
            typeSet.add(imagetype);
        }
    }

    public  Set<String> getTypeSet() {
        return typeSet;
    }

}
