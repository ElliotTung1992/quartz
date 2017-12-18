package com.dongganen.quartz.factory;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.springframework.util.StringUtils;

/**
 * 生成一个jobDetail
 */
public class JobDetailFactory {

    private JobDetailFactory() {
    }

    public static JobDetail createJobDetail(Class jobClass, String jobName, String jobGroup) {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName(jobName);
        jobDetail.setDurability(true);
        jobDetail.setJobClass(jobClass);
        if(StringUtils.isEmpty(jobGroup)){
            jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
        }else {
            jobDetail.setGroup(jobGroup);
        }
        return jobDetail;
    }
}
