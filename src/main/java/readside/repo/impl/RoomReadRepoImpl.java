package readside.repo.impl;

import eventside.domain.Event;
import eventside.domain.EventType;
import readside.domain.Room;
import readside.repo.RoomReadRepo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomReadRepoImpl implements RoomReadRepo {

    static class Occupancy {

        private final LocalDateTime startDate;
        private final Duration duration;
        private final Room room;

        public Occupancy(LocalDateTime startDate, Duration duration, Room room) {
            this.startDate = startDate;
            this.duration = duration;
            this.room = room;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public Duration getDuration() {
            return duration;
        }

        public LocalDateTime getEndDate() {
            return startDate.plus(duration);
        }

        public Room getRoom() {
            return room;
        }
    }

    private Set<Room> allRooms = Set.of(new Room("1", 4),new Room("2", 4), new Room("3", 3));

    private Set<Occupancy> occupancies = new HashSet<>();

    @Override
    public Set<Room> getFreeRooms(LocalDate from, Period period, int numberOfGuests) {

        var largeEnoughRooms = allRooms.stream()
                .filter(p -> p.getMaxGuests() >= numberOfGuests)
                .collect(Collectors.toSet());

        var notFreeRooms = occupancies.stream()
                .filter(p -> p.getEndDate().isAfter(ChronoLocalDateTime.from(from))
                        && p.getStartDate().isBefore(ChronoLocalDateTime.from(from.plus(period))))
                .map(Occupancy::getRoom)
                .collect(Collectors.toSet());

        largeEnoughRooms.removeAll(notFreeRooms);

        return largeEnoughRooms;
    }

    @Override
    public void consume(Event e) {

        if(e.type() == EventType.BOOK) {

            var room = allRooms.stream().filter(p -> p.getRoomNo().equals(e.getRoom())).findFirst().orElseThrow();
            occupancies.add(new Occupancy(e.from(), e.duration(), room));

        } else if(e.type() == EventType.CANCEL) {

            occupancies.removeIf(p -> p.getStartDate().equals(e.from()) &&
                    (p.getDuration().equals(e.duration())) &&
                    (p.getRoom().getRoomNo().equals(e.getRoom())));

        }

    }
}
