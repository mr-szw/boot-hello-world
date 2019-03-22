package com.dawei.boot.boothelloword.controller.userinfo;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.pojo.DemoPojo;
import com.dawei.boot.boothelloword.pojo.UserInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

        //重定向 redirect 客户端的二次请求 || 转发 : forward  服务器内部操作
        return "redirect:/freemarker/index";


    }





}
