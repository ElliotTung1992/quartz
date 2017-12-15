package com.dongganen.quartz.factory;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;

/**
 * 生成一个jobDetail
 */
public class JobDetailFactory {

    private JobDetailFactory() {
    }

    public static JobDetail createJobDetail(Class jobClass, String jobName) {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName(jobName);
        jobDetail.setDurability(true);
        jobDetail.setJobClass(jobClass);
        jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
        return jobDetail;
    }
}
