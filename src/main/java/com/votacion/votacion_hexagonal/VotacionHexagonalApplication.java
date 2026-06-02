package com.votacion.votacion_hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.votacion")
@EntityScan("com.votacion.infrastructure.adapter")
@EnableJpaRepositories("com.votacion.infrastructure.adapter")
public class VotacionHexagonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(VotacionHexagonalApplication.class, args);
    }
}
