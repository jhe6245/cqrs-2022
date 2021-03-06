package readside.repo.impl;

import eventside.domain.Event;
import eventside.domain.EventType;
import org.springframework.stereotype.Repository;
import readside.domain.Booking;
import readside.repo.BookingReadRepo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Repository
public class InMemoryBookingReadRepo implements BookingReadRepo {

    private final Map<LocalDate, Set<Booking>> readModel = new HashMap<>();

    private static List<LocalDate> daysBetween(LocalDateTime from, LocalDateTime until) {

        LocalDate firstDay = from.toLocalDate();
        LocalDate lastDay = until.toLocalDate();

        long numberOfDays = ChronoUnit.DAYS.between(firstDay, lastDay);

        return LongStream.range(0, numberOfDays + 1).mapToObj(firstDay::plusDays).collect(Collectors.toList());
    }

    public void consume(Event e) {

        if(e.getType() == EventType.BOOK) {
            Booking b = new Booking(e.getBookingNo(), e.getCustomer());

            for(LocalDate d: daysBetween(e.getFrom(), e.getUntil())) {
                Set<Booking> existingBookings = readModel.getOrDefault(d, null);

                if(existingBookings != null)
                    existingBookings.add(b);
                else
                    readModel.put(d, new HashSet<>(Set.of(b)));
            }
        }
        else if(e.getType() == EventType.CANCEL) {
            for(LocalDate d: daysBetween(e.getFrom(), e.getUntil())) {
                readModel.get(d).removeIf(b -> b.getBookingNo().equals(e.getBookingNo()));
            }
        }
    }

    @Override
    public Set<Booking> getBookings(LocalDate from, Period period) {

        Set<Booking> bookings = new HashSet<>();

        long days = ChronoUnit.DAYS.between(from, from.plus(period));

        for(long dayOffset = 0; dayOffset <= days; dayOffset++) {
            bookings.addAll(readModel.getOrDefault(from.plusDays(dayOffset), Set.of()));
        }

        return bookings;

    }
}
