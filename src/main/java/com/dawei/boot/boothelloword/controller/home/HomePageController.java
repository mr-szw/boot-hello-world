package com.dawei.boot.boothelloword.controller.home;

import com.alibaba.fastjson.JSON;
import com.dawei.boot.boothelloword.pojo.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dawei 2019/3/24
 */
@RestController
@RequestMapping(value = "/home")
public class HomePageController {

    /**
     * 首页信息
     */
    @GetMapping(value = "/page/info")
    public String homePageInfertion() {
        ResultDto<String> resultDto = new ResultDto<>();
        resultDto.setSuccess();
        return JSON.toJSONString(resultDto);
    }


}
