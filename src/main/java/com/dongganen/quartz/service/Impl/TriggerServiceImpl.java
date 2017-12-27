package com.dongganen.quartz.service.Impl;

import com.dongganen.quartz.service.ITriggerService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriggerServiceImpl implements ITriggerService{

    @Autowired
    private Scheduler scheduler;


}
