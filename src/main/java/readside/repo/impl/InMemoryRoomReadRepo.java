package readside.repo.impl;

import eventside.domain.Event;
import eventside.domain.EventType;
import org.springframework.stereotype.Repository;
import readside.domain.Room;
import readside.repo.RoomReadRepo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class InMemoryRoomReadRepo implements RoomReadRepo {

    static class Occupancy {

        private final LocalDateTime from;
        private final LocalDateTime until;
        private final Room room;

        public Occupancy(LocalDateTime from, LocalDateTime until, Room room) {
            this.from = from;
            this.until = until;
            this.room = room;
        }

        public LocalDateTime getFrom() {
            return from;
        }

        public LocalDateTime getUntil() {
            return until;
        }

        public Room getRoom() {
            return room;
        }
    }

    private final Set<Room> allRooms = Set.of(new Room("1", 4),new Room("2", 4), new Room("3", 3));

    private final Set<Occupancy> occupancies = new HashSet<>();

    @Override
    public Set<Room> getFreeRooms(LocalDateTime from, Duration duration, int numberOfGuests) {

        var largeEnoughRooms = allRooms.stream()
                .filter(p -> p.getMaxGuests() >= numberOfGuests)
                .collect(Collectors.toSet());

        var occupiedRooms = occupancies.stream()
                .filter(p -> p.getUntil().isAfter(from) && p.getFrom().isBefore(from.plus(duration)))
                .map(Occupancy::getRoom)
                .collect(Collectors.toSet());

        largeEnoughRooms.removeAll(occupiedRooms);

        return largeEnoughRooms;
    }

    @Override
    public void consume(Event e) {

        if(e.getType() == EventType.BOOK) {

            var room = allRooms.stream().filter(p -> p.getRoomNo().equals(e.getRoomNo())).findFirst().orElseThrow();
            occupancies.add(new Occupancy(e.getFrom(), e.getUntil(), room));

        } else if(e.getType() == EventType.CANCEL) {

            occupancies.removeIf(p -> p.getFrom().equals(e.getFrom())
                    && (p.getUntil().equals(e.getUntil()))
                    && (p.getRoom().getRoomNo().equals(e.getRoomNo())));

        }

    }
}
