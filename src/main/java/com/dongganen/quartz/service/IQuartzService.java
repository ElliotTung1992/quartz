package com.dongganen.quartz.service;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public interface IQuartzService {

    /**
     * 获取正在运行的计划任务
     * @return
     */
    Map<String,Trigger> getTriggers();

    /**
     * 开始任务
     * @param jobDetail
     * @param trigger
     * @throws SchedulerException
     */
    void start(JobDetail jobDetail, Trigger trigger) throws SchedulerException;

    /**
     * 暂停任务
     * @param taskName
     * @param groupName
     * @throws SchedulerException
     */
    void pauseTask(String taskName, String groupName) throws SchedulerException;

    /**
     * 重启任务
     * @param taskName
     * @param groupName
     */
    void resumeTask(String taskName, String groupName) throws SchedulerException;

    /**
     * 删除任务
     * @param taskName
     * @param groupName
     * @return
     * @throws SchedulerException
     */
    boolean deleteTask(String taskName, String groupName) throws SchedulerException;

    /**
     * 生成一个新的JobDetail
     * @param jobClass
     * @param jobName
     * @return
     */
    JobDetail createJobDetail(Class jobClass, String jobName);

    /**
     * 生成一个新的CronTrigger
     * @param triggerName
     * @param startTime
     * @param endTime
     * @param cronExpression
     * @param jobDetail
     * @return
     */
    CronTriggerImpl createCronTrigger(String triggerName, Date startTime, Date endTime, String cronExpression, JobDetail jobDetail) throws ParseException;
    
}
