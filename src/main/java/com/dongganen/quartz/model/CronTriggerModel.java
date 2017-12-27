package com.dongganen.quartz.model;

public class CronTriggerModel extends TriggerModel {

    private String cronExpression;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public String getTaskTriggerType() {
        return TriggerModel.CRON_TRIGGER_TYPE;
    }

    @Override
    public String toString() {
        return "CronTriggerModel{" +
                "cronExpression='" + cronExpression + '\'' +
                "} " + super.toString();
    }
}
