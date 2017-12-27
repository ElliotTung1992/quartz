package com.dongganen.quartz.service.Impl;

import com.dongganen.quartz.factory.TriggerFactory;
import com.dongganen.quartz.model.SimpleTriggerModel;
import com.dongganen.quartz.model.TriggerModel;
import com.dongganen.quartz.service.ITriggerService;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class TriggerServiceImpl implements ITriggerService{

    @Autowired
    private Scheduler scheduler;

    @Override
    public void createTrigger(TriggerModel triggerModel, JobDetail jobDetail) throws ParseException, SchedulerException {
        Trigger trigger = TriggerFactory.createTrigger(triggerModel, jobDetail);
        scheduler.scheduleJob(trigger);
    }
}
