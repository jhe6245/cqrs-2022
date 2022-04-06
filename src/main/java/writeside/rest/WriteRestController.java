package writeside.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import writeside.application.BookingService;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
public class WriteRestController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "book-room")
    public void bookRoom(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime until,
            @RequestParam String room,
            @RequestParam String customer) {

        bookingService.bookRoom(from, Duration.between(from, until), room, customer);
    }
}
