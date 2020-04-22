package com.dawei.boot.boothelloword.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sinbad on 2020/4/22.
 */
@Controller
public class PageController {





	@GetMapping(value = "/page")
	public String showIndexPage() {
		return "indexPage.html";
	}

}
