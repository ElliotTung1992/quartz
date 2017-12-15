package com.dongganen.quartz.runner;

import com.dongganen.quartz.job.MyJob;
import com.dongganen.quartz.service.IQuartzService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


import java.util.Map;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Component
public class SampleJobRunner implements CommandLineRunner{

    @Autowired
    private IQuartzService quartzService;

    @Override
    public void run(String... strings) throws Exception {
//        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//
//        Scheduler sched = schedFact.getScheduler();
//
//        sched.start();

//         define the job and tie it to our HelloJob class

        Map<String, Trigger> triggers = quartzService.getTriggers();

        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

//         Tell quartz to schedule the job using our trigger
        quartzService.start(job, trigger);

        System.out.println("111111111111111111");
        Thread.currentThread().sleep(50000);
        System.out.println("222222222222222222");

        quartzService.pauseTask("myTrigger", "group1");

        Thread.currentThread().sleep(50000);
        System.out.println("333333333333333333");





        quartzService.resumeTask("myTrigger", "group1");
        Thread.currentThread().sleep(50000);
        System.out.println("444444444444444444");
//        quartzService.deleteTask("myTrigger", "group1");
//        quartzService.shutdown();

    }
}
