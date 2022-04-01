package at.fhv.cqrs;

import eventside.rest.EventRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("eventside")
public class EventSide {

    public static void main(String[] args) {
        SpringApplication.run(EventSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

        };
    }

}
