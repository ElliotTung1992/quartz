package com.dongganen.quartz.service.Impl;

import com.dongganen.quartz.factory.JobDetailFactory;
import com.dongganen.quartz.model.JobBean;
import com.dongganen.quartz.service.IJobDetailService;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JobDetailServiceImpl implements IJobDetailService{

    @Autowired
    private Scheduler scheduler;

    @Override
    public JobDetail createJobDetail(Class jobClass, String jobName, String jobGroup) throws SchedulerException {
        JobDetail jobDetail = JobDetailFactory.createJobDetail(jobClass, jobName, jobGroup);
        scheduler.addJob(jobDetail, true);
        return jobDetail;
    }

    @Override
    public JobBean queryJobDetail(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        JobKey key = jobDetail.getKey();
        JobBean jobBean = new JobBean();
        jobBean.setJobName(key.getName());
        jobBean.setJobGroup(key.getGroup());
        jobBean.setJobClassName(key.getClass().getName());
        return jobBean;
    }

    @Override
    public List<JobBean> queryJobDetailList() throws SchedulerException {
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<JobBean> jobBeans = new ArrayList<>();
        for (JobKey jobKey : jobKeys) {
            JobBean jobBean = queryJobDetail(jobKey.getName(), jobKey.getGroup());
            jobBeans.add(jobBean);
        }
        return jobBeans;
    }

    @Override
    public void deleteJobDetail(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.deleteJob(jobKey);
    }


}
