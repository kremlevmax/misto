package com.maxfromeverett.misto;

import com.maxfromeverett.misto.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class MistoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MistoApplication.class, args);
	}
}
