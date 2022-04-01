package at.fhv.cqrs;

import eventside.domain.Event;
import eventside.domain.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.EventPublisherImpl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private EventPublisherImpl publisher;

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Event event = new Event(
                    "test-1234",
                    "fritz",
                    LocalDateTime.now(),
                    EventType.BOOK,
                    "R123",
                    LocalDateTime.of(LocalDate.of(2022, 4, 10), LocalTime.of(8,0)),
                    Duration.ofDays(7));

            System.out.println("Result: " + publisher.publishEvent(event));
        };
    }
}
