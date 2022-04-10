package writeside.application.impl;

import eventside.domain.Event;
import eventside.domain.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.BookingService;
import writeside.domain.Booking;
import eventside.EventPublisher;
import writeside.domain.Room;
import writeside.domain.repo.BookingWriteRepo;
import writeside.domain.repo.RoomWriteRepo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class BookingServiceImpl implements BookingService {
    @Autowired
    private EventPublisher eventPublisher;
    @Autowired
    private BookingWriteRepo bookingWriteRepo;
    @Autowired
    private RoomWriteRepo roomWriteRepo;

    @Override
    public void bookRoom(LocalDateTime from, Duration duration, String roomNumber, String customer) {

        Room room = roomWriteRepo
                .find(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException("invalid room number"));

        String bookingNo = customer.toLowerCase().split(" ")[0] + new Random().nextInt(1000);

        bookingWriteRepo.put(new Booking(bookingNo, customer, from, duration, room));


        Event e = new Event(EventType.BOOK, LocalDateTime.now(), bookingNo, customer, roomNumber, from, from.plus(duration));
        eventPublisher.publishEvent(e);
    }

    @Override
    public void cancel(String bookingNumber) {
        Booking booking = bookingWriteRepo
                .find(bookingNumber)
                .orElseThrow(() -> new IllegalArgumentException("invalid booking number"));
        booking.cancel();

        Event e = new Event(EventType.CANCEL, LocalDateTime.now(), booking.bookingNumber(), booking.customer(), booking.room().roomNumber(), booking.from(), booking.until());

        eventPublisher.publishEvent(e);
    }
}
