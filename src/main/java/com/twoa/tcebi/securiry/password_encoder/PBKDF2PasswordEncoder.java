package com.twoa.tcebi.securiry.password_encoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class PBKDF2PasswordEncoder implements PasswordEncoder {

    @Value("${tcebi.security.password_encoder.secret}")
    private String secret;
    @Value("${tcebi.security.password_encoder.iteration}")
    private Integer iteration;
    @Value("${tcebi.security.password_encoder.keylength}")
    private Integer keyLength;

    private static final String SECRET_KEY_INSTANCE = "PBKDF2WithHmacSHA512";

    @Override
    public String encode(CharSequence rawPassword) {

        try {
            byte[] encoded = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE)
                    .generateSecret(new PBEKeySpec(rawPassword.toString().toCharArray(),
                            secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(encoded);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
