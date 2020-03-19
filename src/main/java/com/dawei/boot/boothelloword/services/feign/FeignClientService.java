package com.dawei.boot.boothelloword.services.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sinbad on 2020/3/20.
 */
@FeignClient(name = "feignClient-test", fallback = FeignClientServiceImpl.class, url = "${test.feign.url}")
public interface FeignClientService {

	@RequestMapping(value = "/")
	Object getTest();

}
