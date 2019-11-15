package com.test.springbootquartz.config;

import com.test.springbootquartz.quartz.TestJob2;
import com.test.springbootquartz.quartz.TestJob2Method;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * 定时任务配置类
 * @author zqk
 * @since 2019/11/14
 */
@Configuration
public class QuartzConfig {

    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        //Component注解标注的名称
        bean.setTargetBeanName("TestJob1");
        //方法名
        bean.setTargetMethod("test");
        return bean;
    }

    @Bean
    TestJob2Method testJob2Method() {
        return new TestJob2Method();
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(TestJob2.class);
        JobDataMap map = new JobDataMap();
        map.put("test", testJob2Method());
        bean.setJobDataMap(map);
        return bean;
    }

    /**
     * 简单的触发器，设置一些内置的参数即可
     * @return
     */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setStartTime(new Date());
        //重复5次
        bean.setRepeatCount(5);
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        //时间间隔3秒
        bean.setRepeatInterval(3000);
        return bean;
    }

    /**
     * cron表达式的触发器
     * @return
     */
    @Bean
    CronTriggerFactoryBean cronTrigger() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();

        bean.setCronExpression("0 */1 * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }

    /**
     * 配置上面的两个触发器
     * @return
     */
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTrigger().getObject(), simpleTriggerFactoryBean().getObject());
        return bean;
    }

}
