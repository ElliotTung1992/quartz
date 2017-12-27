package com.dongganen.quartz.service;

import com.dongganen.quartz.model.TriggerBean;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IQuartzService {

    /**
     * 获取正在运行的计划任务
     * @return
     */
    List<TriggerBean> getTriggers();

    /**
     * 开始任务
     * @param jobDetail
     * @param trigger
     * @throws SchedulerException
     */
    void start(JobDetail jobDetail, Trigger trigger) throws SchedulerException;

    /**
     * 暂停任务
     * @param triggerName
     * @param triggerGroup
     * @throws SchedulerException
     */
    void pauseTask(String triggerName, String triggerGroup) throws SchedulerException;

    /**
     * 重启任务
     * @param triggerName
     * @param triggerGroup
     */
    void resumeTask(String triggerName, String triggerGroup) throws SchedulerException;

    /**
     * 删除任务
     * @param triggerName
     * @param triggerGroup
     * @return
     * @throws SchedulerException
     */
    boolean deleteTask(String triggerName, String triggerGroup) throws SchedulerException;

}
