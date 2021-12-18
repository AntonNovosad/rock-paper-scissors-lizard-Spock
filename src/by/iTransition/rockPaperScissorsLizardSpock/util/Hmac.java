package by.iTransition.rockPaperScissorsLizardSpock.util;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Hmac {

    public SecretKey generateKey() {
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public String generate(SecretKey key, String text) {
        Mac sha256_HMAC = null;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            sha256_HMAC.init(new SecretKeySpec(key.getEncoded(), "HmacSHA256"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] result = sha256_HMAC.doFinal(text.getBytes());
        return DatatypeConverter.printHexBinary(result);
    }
}
