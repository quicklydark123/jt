package com.jt.aop;

import com.jt.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther Zangyiyi
 * @date 2020/7/8 - 16:23
 */
//标识类是全局异常处理机制的配置类
@RestControllerAdvice
@Slf4j
public class SystemExeAOP {
    /*
     *添加统用异常返回的方法
     * 底层原理:AOP的异常通知
     */
    @ExceptionHandler({RuntimeException.class})
    public Object SystemResultException(Exception exception) {//拦截运行时异常
        //exception.printStackTrace();//如果有问题,则在控制台打印
        log.error(exception.getMessage());
        return SysResult.fail();

    }
}
