package com.test.springbootquartz.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 需要执行的方法
 * @author zqk
 * @since 2019/11/14
 */
public class TestJob2 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TestJob2Method testJob2Method1 = new TestJob2Method();
        testJob2Method1.test();
    }

}
