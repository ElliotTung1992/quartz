package com.dongganen.quartz.service.Impl;

import com.dongganen.quartz.factory.JobDetailFactory;
import com.dongganen.quartz.factory.TriggerFactory;
import com.dongganen.quartz.model.CronTriggerModel;
import com.dongganen.quartz.model.TriggerBean;
import com.dongganen.quartz.service.IQuartzService;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class QuartzServiceImpl implements IQuartzService{

    @Autowired
    private Scheduler scheduler;

    @Override
    public List<TriggerBean> getTriggers() {
        List<TriggerBean> triggerBeans = null;
        try {
            triggerBeans = new ArrayList<>();
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            for (JobKey jobKey : jobKeys) {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                String jobClassName = jobDetail.getJobClass().getName();
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    TriggerBean triggerBean = new TriggerBean();
                    TriggerKey triggerKey = trigger.getKey();
                    triggerBean.setTriggerName(triggerKey.getName());
                    triggerBean.setTriggerGroup(triggerKey.getGroup());
                    triggerBean.setJobName(jobKey.getName());
                    triggerBean.setJobGroup(jobKey.getGroup());
                    triggerBean.setClassName(jobClassName);
                    //获取设置定时器状态
                    String state = scheduler.getTriggerState(triggerKey).toString();
                    triggerBean.setTriggerState(state);
                    //设置开始结束时间
                    triggerBean.setStartTime(trigger.getStartTime());
                    triggerBean.setEndTime(trigger.getEndTime());
                    //获取表达式
                    if(trigger instanceof CronTriggerImpl){
                        CronTriggerImpl cronTrigger = (CronTriggerImpl) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        triggerBean.setCronExpression(cronExpression);
                    }
                    triggerBeans.add(triggerBean);
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return triggerBeans;
    }

    @Override
    public void start(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
//        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void pauseTask(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.pauseTrigger(new TriggerKey(triggerName, triggerGroup));
    }

    @Override
    public void resumeTask(String triggerName, String triggerGroup) throws SchedulerException {
        scheduler.resumeTrigger(new TriggerKey(triggerName, triggerGroup));
    }

    @Override
    public boolean deleteTask(String triggerName, String triggerGroup) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroup);
        scheduler.pauseTrigger(triggerKey);
        return scheduler.unscheduleJob(triggerKey);
    }



    @Override
    public CronTriggerImpl createCronTrigger(String triggerName, String triggerGroup, Date startTime, Date endTime, String cronExpression, JobDetail jobDetail) throws ParseException {
        CronTriggerModel cronTriggerModel = new CronTriggerModel();
        cronTriggerModel.setTriggerName(triggerName);
        cronTriggerModel.setStartTime(startTime);
        cronTriggerModel.setEndTime(endTime);
        cronTriggerModel.setCronExpression(cronExpression);
        cronTriggerModel.setTriggerGroup(triggerGroup);
        CronTriggerImpl cronTrigger = TriggerFactory.createCronTrigger(cronTriggerModel, jobDetail);
        return cronTrigger;
    }

}
