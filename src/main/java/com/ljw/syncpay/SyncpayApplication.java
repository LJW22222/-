package com.ljw.syncpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SyncpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncpayApplication.class, args);
	}

}
