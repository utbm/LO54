package com.mycompany.sp4.webapp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.sp4.core.HelloEntity;
import com.mycompany.sp4.core.HelloService;

import java.util.List;

@Controller
public class ServiceController {

	private final HelloService service;

	@Autowired
	public ServiceController(HelloService service) {
		this.service = service;
	}

	@RequestMapping("/service")
	public String getHello() {
		List<HelloEntity> all = service.findAll();
		return "service";
	}
}
