package com.restful.webservice.restful.webservice.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

	@RequestMapping( path = "/hello-world")
	public String helloworld() {
		return "hello world";
	}
 

	@RequestMapping( path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloworldPathVariable(@PathVariable String name) {
		return new  HelloWorldBean(String.format ("hello world Bean, %s" , name));
	}

}
