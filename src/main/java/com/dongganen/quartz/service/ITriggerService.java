package com.dongganen.quartz.service;


import com.dongganen.quartz.model.TriggerModel;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;

import java.text.ParseException;

public interface ITriggerService {

    /**
     * 创建SimpleTrigger或CronTrigger, 绑定jobDetail
     * @param triggerModel
     * @param jobDetail
     * @throws ParseException
     * @throws SchedulerException
     */
    void createTrigger(TriggerModel triggerModel, JobDetail jobDetail)throws ParseException, SchedulerException;
}
