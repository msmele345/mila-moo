package com.mitchmele.milamoo;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MilaMooApplication implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String urlSecret;
		
	private final SecretClient secretClient;

	public MilaMooApplication(SecretClient secretClient) {
		this.secretClient = secretClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(MilaMooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//vault read properties test
		String dburl = secretClient.getSecret("dburl").getValue();

		System.out.println("KEY VAULT SECRETS: " + dburl);
		System.out.println("KEY VAULT PROPERTIES SECRET: " + urlSecret);
	}
}
