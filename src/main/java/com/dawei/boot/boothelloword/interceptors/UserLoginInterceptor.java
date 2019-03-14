package com.dawei.boot.boothelloword.interceptors;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.pojo.UserInfo;
import com.dawei.boot.boothelloword.utils.RequestHelper;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dawei 2019/3/14
 */
public class UserLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);

    /* 前置拦截 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("User login check ---- ");
        Object userInfoObj = request.getSession().getAttribute("userInfo");
        if(userInfoObj != null) {
            UserInfo userInfo = JSON.parseObject(userInfoObj.toString(), UserInfo.class);
            if(userInfo != null) {
                /*Long userId = RequestHelper.getHeaderLongParm(request, "userId", null);
                if(userId != null && userId.equals(userInfo.getId())) {
                    return true;
                }*/
                return true;
            }
        }
        try {
            response.sendRedirect("/freemarker/login.ftl");
        } catch (IOException e) {
            logger.error("Can`t redirect to login page.");
        }
        return false;
    }
}
