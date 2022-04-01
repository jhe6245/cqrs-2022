package readside.repo;

import eventside.domain.Event;
import readside.domain.Booking;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public interface BookingReadRepo {

    void consume(Event e);

    Set<Booking> getBookings(LocalDate from, Period period);
}
