package com.spring.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/demo")
public class NotificationController {
	
	  @GetMapping("/hello")
	    public String hello() {
	        return "Hello from Spring Boot!";
	    }

}
