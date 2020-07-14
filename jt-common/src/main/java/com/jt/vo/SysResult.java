package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @auther Zangyiyi
 * @date 2020/7/8 - 15:36
 * 说明:什么样的数据需要进行序列化,   对象--->字节数组-->还原回对象,必须序列化
 *                                对象--->json字符串----->还原回对象无需序列化 因为用的是get/set方法
 */
@Data

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysResult implements Serializable {
    /*
     * 策略说明:　
     * 		属性1: status==200 调用正确 status==201 调用失败
     * 		属性2: msg 提交服务器相关说明信息
     * 		属性3: data 服务器返回页面的业务数据 一般都是对象的JSON.
     */
    private Integer status;
    private String msg;
    private Object data;


    //准备工具API 方便用户使用
    public static SysResult fail() {

        return new SysResult(201, "业务调用失败", null);
    }

    //成功方式1 只返回状态码信息
    public static SysResult success() {

        return new SysResult(200, "业务调用成功!!!", null);
    }

    //成功方式2 需要返回服务器数据 data
    public static SysResult success(Object data) {

        return new SysResult(200, "业务调用成功!!!", data);
    }

    //成功方式3  可能告知服务器信息及 服务器数据
    public static SysResult success(String msg, Object data) {

        return new SysResult(200, msg, data);
    }
}
