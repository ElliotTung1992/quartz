package com.dongganen.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello world!  " + returnDate(new Date()));
    }

    public String returnDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String format1 = format.format(date);
        return format1;
    }
}
