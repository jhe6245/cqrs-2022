package readside.repo;

import eventside.domain.Event;
import readside.domain.Room;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public interface RoomReadRepo {

    void consume(Event e);

    Set<Room> getFreeRooms(LocalDateTime from, Duration duration, int numberOfGuests);
}
