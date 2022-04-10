package writeside.infra;

import org.springframework.stereotype.Repository;
import writeside.domain.Booking;
import writeside.domain.repo.BookingWriteRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public class InMemoryBookingWriteRepo implements BookingWriteRepo {

    private final Collection<Booking> bookings = new ArrayList<>();

    @Override
    public void put(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public Optional<Booking> find(String bookingNumber) {
        return bookings.stream().filter(b -> b.bookingNumber().equals(bookingNumber)).findFirst();
    }
}
