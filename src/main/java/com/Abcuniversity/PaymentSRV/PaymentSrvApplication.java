package com.Abcuniversity.PaymentSRV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class PaymentSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSrvApplication.class, args);
	}

}
