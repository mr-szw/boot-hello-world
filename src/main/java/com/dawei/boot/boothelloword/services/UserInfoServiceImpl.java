package com.dawei.boot.boothelloword.services;

import com.dawei.boot.boothelloword.pojo.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by Dawei on 2019/3/22.
 * @deprecated 用户信息操作服务
 */
@Service
public class UserInfoServiceImpl {


    /**
     * 通过登陆信息获取用户信息
     * @param loginName 登陆名
     * @return 用户信息
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserInfo getUserInfoById(String loginName) {

        return null;
    }

}
