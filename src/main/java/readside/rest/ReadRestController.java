package readside.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import readside.domain.Booking;
import readside.domain.Room;
import readside.repo.BookingReadRepo;
import readside.repo.RoomReadRepo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;

@RestController
public class ReadRestController {

    @Autowired
    private BookingReadRepo bookingReadRepo;

    @Autowired
    private RoomReadRepo roomReadRepo;

    @GetMapping(value = "get-bookings", produces = "application/json")
    public Set<Booking> getBookings(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate until) {

        return bookingReadRepo.getBookings(from, Period.between(from, until));
    }


    @GetMapping(value = "get-free-rooms", produces = "application/json")
    public Set<Room> getFreeRooms(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime until,
            @RequestParam int numberOfGuests) {

        return roomReadRepo.getFreeRooms(from, Duration.between(from, until), numberOfGuests);
    }

}
