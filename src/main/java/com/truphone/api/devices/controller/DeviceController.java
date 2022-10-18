package com.truphone.api.devices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello";
	}

}
