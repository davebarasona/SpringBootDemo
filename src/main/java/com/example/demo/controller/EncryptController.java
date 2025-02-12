package com.example.demo.controller;

import com.example.demo.utils.CipherUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/encrypt")
public class EncryptController {

    private CipherUtility cipherUtility;

    public EncryptController(CipherUtility cipherUtility) {
        this.cipherUtility = cipherUtility;
    }

    @GetMapping
    public String encryptText(String message) throws Exception {
        Map<String, String> map = cipherUtility.dataEncryption(message);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("original Data: "+message +"\n");
        stringBuilder.append("Encrypted: \n");
        stringBuilder.append(map.get("encryptedData"));
        stringBuilder.append("\n Decrypded: "+map.get("decryptedData"));
        return stringBuilder.toString();
    }

}
