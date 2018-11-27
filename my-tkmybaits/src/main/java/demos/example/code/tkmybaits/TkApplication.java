package demos.example.code.tkmybaits;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class TkApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TkApplication.class).web(true).run(args);
    }
}
