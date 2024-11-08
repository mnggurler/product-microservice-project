package org.ayrotek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProductServiceApplication.class, args);
    }
}
