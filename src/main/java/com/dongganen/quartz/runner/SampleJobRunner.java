package com.dongganen.quartz.runner;

import com.dongganen.quartz.job.MyJob;
import com.dongganen.quartz.job.SeJob;
import com.dongganen.quartz.model.TriggerBean;
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

    @Override
    public void run(String... strings) throws Exception {
        quartzService.deleteTask("SeTrigger", "group2");
        quartzService.deleteTask("myTrigger", "group1");
        quartzService.createJobDetail(MyJob.class, "myJob", "");

    }
}
