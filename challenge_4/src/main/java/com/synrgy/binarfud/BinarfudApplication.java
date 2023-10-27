package com.synrgy.binarfud;

import com.synrgy.binarfud.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinarfudApplication {

	public static void main(String[] args) {
		HomeController homeController = SpringApplication.run(BinarfudApplication.class, args)
				.getBean(HomeController.class);

		homeController.home();
	}

}
