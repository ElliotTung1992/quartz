package com.dongganen.quartz.service;

import com.dongganen.quartz.model.JobBean;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;

import java.util.List;

public interface IJobDetailService {

    /**
     * 生成一个新的JobDetail
     * @param jobClass
     * @param jobName
     * @return
     */
    JobDetail createJobDetail(Class jobClass, String jobName, String jobGroup) throws SchedulerException;

    /**
     * 根据jobName和jobGroup返回JobDetail
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    JobBean queryJobDetail(String jobName, String jobGroup) throws SchedulerException;

    /**
     * 返回JobDetail集合
     * @return
     * @throws SchedulerException
     */
    List<JobBean> queryJobDetailList() throws SchedulerException;

    /**
     * 删除JobDetail
     * @param jobName
     * @param jobGroup
     * @throws SchedulerException
     */
    void deleteJobDetail(String jobName, String jobGroup) throws SchedulerException;
}
