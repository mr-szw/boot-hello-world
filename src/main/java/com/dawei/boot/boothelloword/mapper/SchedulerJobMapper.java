package com.dawei.boot.boothelloword.mapper;


import com.dawei.boot.boothelloword.entity.SchedulerJob;
import java.util.List;

public interface SchedulerJobMapper {

    SchedulerJob selectByPrimaryKey(String jobId);

    List<SchedulerJob> selectJobList(SchedulerJob schedulerJob);

    int deleteByPrimaryKey(String jobId);

    int insertSelective(SchedulerJob record);

    int updateByPrimaryKeySelective(SchedulerJob record);

    int updateJobStatus(SchedulerJob schedulerJob);

    int updateJobCron(SchedulerJob schedulerJob);
}