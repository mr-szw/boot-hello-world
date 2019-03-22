package com.dawei.boot.boothelloword.interceptors;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.pojo.UserInfo;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

    //方法业务处理之后再调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    //页面渲染完成之后 通常用于清除某些资源，类似Finally
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
