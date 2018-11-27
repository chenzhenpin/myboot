package demos.example.code.jwt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JWTApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JWTApplication.class).web(true).run(args);
    }
}