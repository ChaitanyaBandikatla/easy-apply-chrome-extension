package com.example.easyapply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EasyapplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyapplyApplication.class, args);
	}

	@RequestMapping("/")
	public String FirstPage() {
		return "We succeed. we are viewing our first page.";
	}
}
