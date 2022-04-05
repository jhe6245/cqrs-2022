package readside.repo;

import eventside.domain.Event;
import readside.domain.Room;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public interface RoomReadRepo {

    Set<Room> getFreeRooms(LocalDate from, Period period, int numberOfGuests);

    void consume(Event e);


}
