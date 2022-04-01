package writeside.application.impl;

import eventside.domain.Event;
import eventside.domain.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import writeside.application.BookingService;
import writeside.domain.Booking;
import writeside.domain.EventPublisher;
import writeside.domain.Room;
import writeside.domain.repo.BookingRepository;
import writeside.domain.repo.RoomRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class BookingServiceImpl implements BookingService {
    @Autowired
    private EventPublisher eventPublisher;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void bookRoom(LocalDateTime from, Duration duration, String roomNumber, String customer) {

        Room room = roomRepository
                .find(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException("invalid room number"));

        String bookingNo = customer.toLowerCase().split(" ")[0] + new Random().nextInt(1000);

        bookingRepository.put(new Booking(bookingNo, customer, from, duration, room));


        Event e = new Event(bookingNo, customer, LocalDateTime.now(), EventType.BOOK, roomNumber, from, duration);
        eventPublisher.publishEvent(e);
    }

    @Override
    public void cancel(String bookingNumber) {
        Booking booking = bookingRepository
                .find(bookingNumber)
                .orElseThrow(() -> new IllegalArgumentException("invalid booking number"));
        booking.cancel();

        Event e = new Event(bookingNumber, booking.customer(), LocalDateTime.now(), EventType.CANCEL, booking.room().roomNumber(), booking.from(), booking.duration());
        eventPublisher.publishEvent(e);
    }
}
