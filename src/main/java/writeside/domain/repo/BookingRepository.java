package writeside.domain.repo;

import writeside.domain.Booking;

import java.util.Optional;


public interface BookingRepository {
    void put(Booking booking);

    Optional<Booking> find(String bookingNumber);
}
