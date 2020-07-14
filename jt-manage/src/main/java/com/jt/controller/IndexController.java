package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 实现:RestFul风格
 * 语法:
 * 1.使用/方式分割参数
 * 2.使用{}包裹参数
 * 3.在参数方法中 动态接受参数时使用特定注解@PathVariable
 * 注解:@PathVariable
 * name/value 表示接收参数的名称
 * required 改参数是否必须 默认true
 * 作用1:动态获取url路径中的参数
 * 作用2:以统一的url地址,用不同的方法实行,实现不同业务的调用.
 * 简化:url的个数
 * <p>
 * restFul风格2:
 * 例子1:http://www.jt.com/user?id=1 查询  GET
 * 例子2:http://www.jt.com/user?id=1 删除  DELETE
 * 例子3:http://www.jt.com/user?id=1&name=xxx 更新  PUT
 * 例子4:http://www.jt.com/user 新增   POST
 */
@Controller
public class IndexController {

    @RequestMapping("/page/{moduleName}")
    public String module(@PathVariable String moduleName) {

        return moduleName;
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String demo1(Integer id) {
//        //查询
//        return null;
//    }
//
//    @PostMapping("/user")
//    public String demo2(User user) {
//        //新增
//        return null;
//    }
}
