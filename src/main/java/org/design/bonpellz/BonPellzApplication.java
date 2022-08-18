package org.design.bonpellz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class BonPellzApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonPellzApplication.class, args);
    }

    @Bean
    JavaMailSenderImpl javaMailSender(){
        return new JavaMailSenderImpl();
    }

}
