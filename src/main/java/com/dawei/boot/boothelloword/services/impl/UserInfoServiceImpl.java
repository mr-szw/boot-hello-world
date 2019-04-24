package com.dawei.boot.boothelloword.services.impl;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.entity.SchedulerJob;
import com.dawei.boot.boothelloword.mapper.SchedulerJobMapper;
import com.dawei.boot.boothelloword.pojo.UserInfo;
import com.dawei.boot.boothelloword.services.IUserInfoService;
import com.dawei.boot.boothelloword.utils.UniqueIDUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by Dawei on 2019/3/22. 用户信息操作服务
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private SchedulerJobMapper schedulerJobMapper;

    /**
     * 通过登陆信息获取用户信息
     *
     * @param loginName 登陆名
     * @return 用户信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo getUserInfoById(String loginName) {
        List<String> jobIdList = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            SchedulerJob schedulerJob = new SchedulerJob();
            String uniqueID = UniqueIDUtil.getUniqueID().toString();
            jobIdList.add(uniqueID);
            schedulerJob.setJobId(uniqueID);
            schedulerJob.setClusterName(UUID.randomUUID().toString());
            schedulerJob.setCronStr("1 * * * 8 *  ?");
            schedulerJob.setDescription("wu");
            schedulerJob.setJobClassName(UUID.randomUUID().toString());
            schedulerJob.setJobName(UUID.randomUUID().toString());
            schedulerJob.setStatus(1);
            schedulerJob.setWelfareEmail("15554485117@163.com");
            schedulerJob.setMethodParamName("A");
            schedulerJobMapper.insertSelective(schedulerJob);
        }

        Iterator<String> iterator =
            jobIdList.iterator();
        while (iterator.hasNext()) {
            SchedulerJob schedulerJob = schedulerJobMapper.selectByPrimaryKey(iterator.next());
            System.out.println(JSON.toJSONString(schedulerJob));
        }
        return null;
    }

}
