package com.dawei.boot.boothelloword.entity;

import java.io.Serializable;

/**
 * @author by Dawei on 2019/3/30.
 */
public class SchedulerJob implements Serializable {

    private String jobId;
    //任务执行集群
    private String clusterName;
    //声明任务名
    private String jobName;
    //执行类名
    private String jobClassName;
    //执行方法名
    private String jobMethodName;
    //方法参数名 仅限一个值
    private String methodParamName;
    //方法参数值 仅限一个值
    private String methodParamValue;
    //任务执行时间
    private String cronStr;
    //任务状态
    private Integer status;
    //负责人邮箱
    private String welfareEmail;
    //描述信息
    private String description;

    public SchedulerJob() {
    }

    public SchedulerJob(String jobId, String clusterName, String jobName, String jobClassName, String jobMethodName, String methodParamName, String methodParamValue, String cronStr, Integer status, String welfareEmail, String description) {
        this.jobId = jobId;
        this.clusterName = clusterName;
        this.jobName = jobName;
        this.jobClassName = jobClassName;
        this.jobMethodName = jobMethodName;
        this.methodParamName = methodParamName;
        this.methodParamValue = methodParamValue;
        this.cronStr = cronStr;
        this.status = status;
        this.welfareEmail = welfareEmail;
        this.description = description;
    }

    public SchedulerJob(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getJobMethodName() {
        return jobMethodName;
    }

    public void setJobMethodName(String jobMethodName) {
        this.jobMethodName = jobMethodName;
    }

    public String getMethodParamName() {
        return methodParamName;
    }

    public void setMethodParamName(String methodParamName) {
        this.methodParamName = methodParamName;
    }

    public String getMethodParamValue() {
        return methodParamValue;
    }

    public void setMethodParamValue(String methodParamValue) {
        this.methodParamValue = methodParamValue;
    }

    public String getCronStr() {
        return cronStr;
    }

    public void setCronStr(String cronStr) {
        this.cronStr = cronStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWelfareEmail() {
        return welfareEmail;
    }

    public void setWelfareEmail(String welfareEmail) {
        this.welfareEmail = welfareEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

