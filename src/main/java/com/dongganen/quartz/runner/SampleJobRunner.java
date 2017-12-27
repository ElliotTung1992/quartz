package com.dongganen.quartz.runner;

import com.dongganen.quartz.factory.JobDetailFactory;
import com.dongganen.quartz.job.MyJob;
import com.dongganen.quartz.job.SeJob;
import com.dongganen.quartz.model.CronTriggerModel;
import com.dongganen.quartz.model.JobBean;
import com.dongganen.quartz.model.SimpleTriggerModel;
import com.dongganen.quartz.model.TriggerBean;
import com.dongganen.quartz.service.IJobDetailService;
import com.dongganen.quartz.service.IQuartzService;
import com.dongganen.quartz.service.ITriggerService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
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
    private ITriggerService triggerService;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... strings) throws Exception {
        quartzService.deleteTask("myTrigger", "DEFAULT");
//        quartzService.deleteTask("myTrigger", "group1");
//        jobDetailService.createJobDetail(MyJob.class, "myJob", "");
//        jobDetailService.createJobDetail(SeJob.class, "seJob", "");
//        List<JobBean> jobBeans = jobDetailService.queryJobDetailList();
//        jobDetailService.deleteJobDetail("myJob", "DEFAULT");
//        quartzService.createCronTrigger("aaa", null, null, null, "1 * * * * ?", scheduler.getJobDetail(new JobKey("myJob", "DEFAULT")));

//        SimpleTriggerModel simpleTriggerModel = new SimpleTriggerModel();
//        simpleTriggerModel.setTriggerName("myTrigger");
//        simpleTriggerModel.setTriggerGroup("DEFAULT");
//        simpleTriggerModel.setStartTime(new Date());
//        simpleTriggerModel.setRepeatInterval(10l);
//        simpleTriggerModel.setRepeatCount(10l);
//
//        LocalDate localDate = LocalDate.now().plusDays(1);
//        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
//        Date date = Date.from(atZone.toInstant());
//
//        simpleTriggerModel.setEndTime(date);
//
//        JobKey jobKey = new JobKey("myJob", "DEFAULT");
//        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
////        JobDetail jobDetail = JobDetailFactory.createJobDetail(MyJob.class, "myJob", null);
//        triggerService.createSimpleTrigger(simpleTriggerModel, jobDetail);

        CronTriggerModel cronTriggerModel = new CronTriggerModel();
        cronTriggerModel.setTriggerName("myTrigger1");
        cronTriggerModel.setTriggerGroup("DEFAULT");
        cronTriggerModel.setStartTime(new Date());

        LocalDate localDate = LocalDate.now().plusDays(1);
        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());

        cronTriggerModel.setEndTime(date);
        cronTriggerModel.setCronExpression("* * * * * ?");

        JobKey jobKey = new JobKey("myJob", "DEFAULT");
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        triggerService.createTrigger(cronTriggerModel, jobDetail);

    }
}
