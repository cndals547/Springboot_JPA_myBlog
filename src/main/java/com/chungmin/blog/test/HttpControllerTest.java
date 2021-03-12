package com.chungmin.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpContrllerTest";
	
	@GetMapping("/http/lombok")
	private String lombokTest(Member m) {
		System.out.println(TAG + "getter : " +m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : " +m.getId());
		Member m1 = new Member(1,"hi","password","email");
		Member m2 = new Member();
		return "get test : "+ m.getId() +" username : "+m.getUsernanme()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get test : "+ m.getId() +" username : "+m.getUsernanme()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put test : "+ m.getId() +" username : "+m.getUsernanme()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //Message Converter(Spring Boot)
		return "postf test : "+ m.getId() +" username : "+m.getUsernanme()+" passwrod : " +m.getPassword()+" email : " +m.getEmail();
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "get test";
	}
}
