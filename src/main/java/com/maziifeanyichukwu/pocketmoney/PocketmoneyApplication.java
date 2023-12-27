package com.maziifeanyichukwu.pocketmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PocketmoneyApplication {

	public static void main(String[] args) {

		SpringApplication.run(PocketmoneyApplication.class, args);
	}
	@GetMapping("/")
	public String welcome(){
		return "Hello Its pocketMoneyAPI";
	}

}
