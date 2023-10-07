package com.sankidev.gcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.spring.autoconfigure.storage.GcpStorageAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {GcpStorageAutoConfiguration.class})
public class GcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcsApplication.class, args);
	}

}
