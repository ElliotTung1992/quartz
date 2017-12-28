package com.dongganen.quartz.model;

import java.util.Date;

/**
 * Trigger 属性
 *
 * @author yan.liang@ustcinfo.com
 * @date 2017/7/17
 */
public abstract class TriggerModel {

    public static final String SIMPLE_TRIGGER_TYPE = "SIMPLE_TRIGGER";
    public static final String CRON_TRIGGER_TYPE = "CRON_TRIGGER";

    private String triggerName; // 触发器唯一名称
    private String triggerGroup;  //触发器组名称
    private Date startTime;  // 开始时间
    private Date endTime;    // 结束时间
    private String desc;     // 任务描述

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public abstract String getTaskTriggerType();

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TriggerModel{" +
                "triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", desc='" + desc + '\'' +
                '}';
    }
}
