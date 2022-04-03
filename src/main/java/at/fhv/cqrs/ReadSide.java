package at.fhv.cqrs;

import eventside.EventConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("readside")
public class ReadSide {

    @Autowired
    private EventConsumer eventConsumer;

    public static void main(String[] args) {
        SpringApplication.run(ReadSide.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            eventConsumer.subscribe("http://localhost:8080");
        };
    }

}
