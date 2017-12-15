package com.dongganen.quartz.spring_quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * spring自带定时器实现
 * 多个定时器一起跑会出问题
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    /**
     * 开始时间是项目启动时间算起
     * 1000 * 30 每30秒执行一次
     * 1000 * 60 * 2 每2分钟执行一次
     */
    @Scheduled(fixedRate = 1000 * 5)
    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
//        for (int i = 0; i < 1000000; i++){
//            for (int j = 0; j < 1000; j++){
//            }
//        }
    }

    //每1分钟执行一次
    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron(){
//        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
    }

    /**
     * 11:27:45
     * 11:27:51
     * 方法执行完成后(消耗时间) + 5秒
     */
    @Scheduled(fixedDelay = 1000 * 5)
    public void fixedDelay(){
//        System.out.println ("Scheduling Tasks Examples fixedDelay: The time is now " + dateFormat ().format (new Date()));
//        for (int i = 0; i < 1000000; i++){
//            for (int j = 0; j < 1000; j++){
//            }
//        }
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
}
