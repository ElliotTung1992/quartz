package com.dongganen.quartz.service.Impl;

import com.dongganen.quartz.factory.JobDetailFactory;
import com.dongganen.quartz.factory.TriggerFactory;
import com.dongganen.quartz.model.CronTriggerModel;
import com.dongganen.quartz.service.IQuartzService;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class QuartzServiceImpl implements IQuartzService{

    @Autowired
    private Scheduler scheduler;

    @Override
    public Map<String, Trigger> getTriggers() {
        Map<String,Trigger> triggerMap = new HashMap<String,Trigger>();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = null;
        try {
            jobKeys = scheduler.getJobKeys(matcher);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        for (JobKey jobKey : jobKeys) {
            List<? extends Trigger> triggers = null;
            try {
                triggers = scheduler.getTriggersOfJob(jobKey);
            } catch (SchedulerException e1) {
                e1.printStackTrace();
            }
            for (Trigger trigger : triggers) {
                triggerMap.put(jobKey.getGroup()+"."+jobKey.getName(), trigger);
            }
        }
        return triggerMap;
    }

    @Override
    public void start(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void pauseTask(String taskName, String groupName) throws SchedulerException {
        scheduler.pauseTrigger(new TriggerKey(taskName, groupName));
    }

    @Override
    public void resumeTask(String taskName, String groupName) throws SchedulerException {
        scheduler.resumeTrigger(new TriggerKey(taskName, groupName));
    }

    @Override
    public boolean deleteTask(String taskName, String groupName) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(taskName, groupName);
        scheduler.pauseTrigger(triggerKey);
        return scheduler.unscheduleJob(triggerKey);
    }

    @Override
    public JobDetail createJobDetail(Class jobClass, String jobName){
        JobDetail jobDetail = JobDetailFactory.createJobDetail(jobClass, jobName);
        return jobDetail;
    }

    @Override
    public CronTriggerImpl createCronTrigger(String triggerName, Date startTime, Date endTime, String cronExpression, JobDetail jobDetail) throws ParseException {
        CronTriggerModel cronTriggerModel = new CronTriggerModel();
        cronTriggerModel.setTriggerName(triggerName);
        cronTriggerModel.setStartTime(startTime);
        cronTriggerModel.setEndTime(endTime);
        cronTriggerModel.setCronExpression(cronExpression);
        CronTriggerImpl cronTrigger = TriggerFactory.createCronTrigger(cronTriggerModel, jobDetail);
        return cronTrigger;
    }

}
