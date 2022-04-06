package at.fhv.cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.application.BookingService;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private BookingService bookingService;

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {

            bookingService.bookRoom(
                    LocalDateTime.of(2022, 4, 10, 8, 0),
                    Duration.ofDays(3),
                    "2",
                    "max");

            bookingService.bookRoom(
                    LocalDateTime.of(2022, 4, 15, 8, 0),
                    Duration.ofDays(5),
                    "3",
                    "max");
        };
    }
}
