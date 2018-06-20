package com.test.SpringIntegrationSmbTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value={"classpath:integration/SmbIntegrationContext.xml"})
public class SpringIntegrationSmbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationSmbTestApplication.class, args);
	}
}
