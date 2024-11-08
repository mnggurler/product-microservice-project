package org.ayrotek;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TaxCalculationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaxCalculationServiceApplication.class, args);
    }
}
