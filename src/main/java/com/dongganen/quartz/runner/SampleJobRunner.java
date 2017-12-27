package com.dongganen.quartz.runner;

import com.dongganen.quartz.job.MyJob;
import com.dongganen.quartz.job.SeJob;
import com.dongganen.quartz.model.JobBean;
import com.dongganen.quartz.model.TriggerBean;
import com.dongganen.quartz.service.IJobDetailService;
import com.dongganen.quartz.service.IQuartzService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Component
public class SampleJobRunner implements CommandLineRunner{

    @Autowired
    private IQuartzService quartzService;

    @Autowired
    private IJobDetailService jobDetailService;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... strings) throws Exception {
//        quartzService.deleteTask("SeTrigger", "group2");
//        quartzService.deleteTask("myTrigger", "group1");
//        jobDetailService.createJobDetail(MyJob.class, "myJob", "");
//        jobDetailService.createJobDetail(SeJob.class, "seJob", "");
//        List<JobBean> jobBeans = jobDetailService.queryJobDetailList();
//        jobDetailService.deleteJobDetail("seJob", "DEFAULT");
        quartzService.createCronTrigger("aaa", null, null, null, "1 * * * * ?", scheduler.getJobDetail(new JobKey("myJob", "DEFAULT")));
    }
}
