package com.dawei.boot.boothelloword.controller.userinfo;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.pojo.DemoPojo;
import com.dawei.boot.boothelloword.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Dawei 2019/3/14
 */
@Controller
@RequestMapping(value = "/user")
public class UserLoginController {

    /**
     *  登陆主接口
     * @return
     */
    @GetMapping(value = "/login")
    public String userLogin(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(System.currentTimeMillis());
        session.setAttribute("userInfo", JSON.toJSONString(userInfo));
        DemoPojo demoPojo = new DemoPojo();
        demoPojo.setUserName("ABC");
        request.setAttribute("demoPojo", demoPojo);

        return "/freemarker/index";


    }





}
