package com.dawei.boot.boothelloword.services.feign;

import org.springframework.stereotype.Service;

/**
 * @author Sinbad on 2020/3/20.
 */
@Service
public class FeignClientServiceImpl implements FeignClientService {


	@Override
	public Object getTest() {
		System.out.println("Failed getTest");
		return "Failed";
	}


}
