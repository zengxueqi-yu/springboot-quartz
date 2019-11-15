package com.test.springbootquartz.quartz;

import java.util.Date;

/**
 * 需要执行的方法
 * @author zqk
 * @since 2019/11/14
 */
public class TestJob2Method{

    public void test(){
        System.out.println("TestJob2测试定时任务 ===> " + new Date());
    }

}
