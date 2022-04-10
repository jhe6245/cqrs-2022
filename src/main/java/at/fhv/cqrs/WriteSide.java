package at.fhv.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("writeside")
public class WriteSide {

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }

}
