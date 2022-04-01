package readside;

import readside.domain.Booking;
import readside.domain.Room;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public interface HotelQueryService {


    Set<Booking> getBookings(LocalDateTime from, Duration duration);

    Set<Room> getFreeRooms(LocalDateTime from, Duration duration);
}
