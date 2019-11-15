package com.test.springbootquartz.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 需要执行的方法
 * @author zqk
 * @since 2019/11/14
 */
@Component(value = "TestJob1")
public class TestJob1 {

    public void test(){
        System.out.println("TestJob1测试定时任务 ===> " + new Date());
    }

}
