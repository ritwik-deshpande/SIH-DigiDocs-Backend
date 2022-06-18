package com.example.SIH;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder customPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                //String salt = BCrypt.gensalt(4);
                String salt = "$2a$04$XkEO9KJolCWvmniNP4VHWe";
                //hashcode = "$2a$04$XkEO9KJolCWvmniNP4VHWeWoBG3534aq4CopyoO42JSOAqczt5uBm"
                System.out.println(salt);
                return BCrypt.hashpw(rawPassword.toString(),salt);

            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
            }
        };
    }
}