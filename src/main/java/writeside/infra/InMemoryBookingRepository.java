package writeside.infra;

import org.springframework.stereotype.Repository;
import writeside.domain.Booking;
import writeside.domain.repo.BookingRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public class InMemoryBookingRepository implements BookingRepository {

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
