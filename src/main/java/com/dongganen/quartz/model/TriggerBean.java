package com.dongganen.quartz.model;


import java.util.Date;

public class TriggerBean {


    private String triggerName;         //触发器名称
    private String triggerGroup;        //触发器分组
    /**
        WAITING:等待
        PAUSED:暂停
        ACQUIRED:正常执行
        BLOCKED：阻塞
        ERROR：错误
     */
    private String triggerState;        //触发器状态
    private String jobName;             //工作名称
    private String jobGroup;            //工作分组
    private String className;           //工作class类全路径
    private Date startTime;             //开始时间
    private Date endTime;               //结束时间
    private String cronExpression;      //表达式
    private Integer type;               //类型0:SimpleTrigger 1:CronTrigger
    private Integer repeatCount;           //重复次数
    private long repeatInterval;        //重复间隔
    private String desc;                //详情描述

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TriggerBean{" +
                "triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", triggerState='" + triggerState + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", className='" + className + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", cronExpression='" + cronExpression + '\'' +
                ", type=" + type +
                ", repeatCount=" + repeatCount +
                ", repeatInterval=" + repeatInterval +
                ", desc='" + desc + '\'' +
                '}';
    }
}
