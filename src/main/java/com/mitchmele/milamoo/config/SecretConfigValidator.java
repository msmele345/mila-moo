package com.mitchmele.milamoo.config;

import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SecretConfigValidator implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String urlSecret;

    private final KeyVaultClient keyVaultClient;

    public SecretConfigValidator(
            @Qualifier("KeyVaultAutoconfiguredClient") KeyVaultAutoconfiguredClient keyVaultAutoconfiguredClient
    ) {
        this.keyVaultClient = keyVaultAutoconfiguredClient;
    }

    @Override
    public void run(String... args) throws Exception {
        KeyVaultSecret keyVaultSecret = keyVaultClient.getSecret("dburl");

        System.out.println("KEY VAULT SECRETE: " + keyVaultSecret);
        System.out.println("KEY VAULT PROPERTIES SECRET: " + urlSecret);
    }
}
