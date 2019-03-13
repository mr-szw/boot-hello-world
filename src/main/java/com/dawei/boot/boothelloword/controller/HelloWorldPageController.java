package com.dawei.boot.boothelloword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by Dawei on 2019/3/12.
 * 用于页面返回的
 */
@Controller
@RequestMapping("/page")
public class HelloWorldPageController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


    /**
     * 视图返回
     */
    @RequestMapping(value = "/index")
    public String toIndexPage() {
        logger.info("To index page .... ");
        return "freemarker/index";
    }









}
