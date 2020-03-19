package com.dawei.boot.boothelloword.controller.feign;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawei.boot.boothelloword.services.feign.FeignClientService;

/**
 * @author Sinbad on 2020/3/20.
 */
@RestController
@RequestMapping(value = "/feign/test/")
public class FeignClientController {


	@Resource
	private FeignClientService feignClientService;



	@GetMapping(value = "/client")
	public Object testFeign() {
		return 		feignClientService.getTest();
	}


}
