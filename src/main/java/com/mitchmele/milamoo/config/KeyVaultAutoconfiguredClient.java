package com.mitchmele.milamoo.config;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.stereotype.Component;

@Component("KeyVaultAutoconfiguredClient")
public class KeyVaultAutoconfiguredClient implements KeyVaultClient {

    //	private final KeyVaultClient keyVaultClient;
//
//	public MilaMooApplication(
//			@Qualifier("KeyVaultAutoconfiguredClient") KeyVaultAutoconfiguredClient keyVaultAutoconfiguredClient
//	) {
//		this.keyVaultClient = keyVaultAutoconfiguredClient;
//	}

    private final SecretClient secretClient;

    public KeyVaultAutoconfiguredClient(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    @Override
    public SecretClient getSecretClient() {
        return secretClient;
    }
}
