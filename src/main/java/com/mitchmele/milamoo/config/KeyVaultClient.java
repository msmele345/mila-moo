package com.mitchmele.milamoo.config;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

import java.util.NoSuchElementException;

public interface KeyVaultClient {

    SecretClient getSecretClient();

    default KeyVaultSecret getSecret(String key) {
        KeyVaultSecret keyVaultSecret;
        try {
            keyVaultSecret = getSecretClient().getSecret(key);
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("Unable to retrieve %s secret", key), e);
        }
        return keyVaultSecret;
    }
}
