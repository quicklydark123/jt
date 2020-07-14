package com.jt.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Zangyiyi
 * @date 2020/7/7 - 17:12
 */

//表示配置类   .xml 配置文件
@Configuration
public class MybatisPlusConfig {

    //一般和bean注解联用 ,表示将返回的对象实例化之后,交给spring容器管理
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }
}


