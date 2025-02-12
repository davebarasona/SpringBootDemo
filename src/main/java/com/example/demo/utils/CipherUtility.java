package com.example.demo.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class CipherUtility {

    public Map<String, String> dataEncryption(String text) throws Exception {
        Map<String, String> map = new HashMap<>();

        /* Step 1: Generate KeyPair */
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        /* Step 2: Get private and public key */
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        /* Step 3: Encryption */
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        cipher.doFinal(text.getBytes());
        byte[] encryptedText = cipher.doFinal(text.getBytes());

        map.put("encryptedData", new String(encryptedText));
        map.put("decryptedData", dataDecryption(encryptedText, privateKey));
        return map;
    }

    public String dataDecryption(byte[] encryptedData, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encryptedData));
    }
}
