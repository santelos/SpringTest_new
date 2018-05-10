package com.example.SpringTest;

import com.example.SpringTest.Storage.FileSystemStorageService;
import com.example.SpringTest.Storage.StorageProperties;
import com.example.SpringTest.Storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args -> {
//			storageService.deleteAll();
			storageService.init();
		});
	}
}
