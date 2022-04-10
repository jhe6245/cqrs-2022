package writeside.infra;

import org.springframework.stereotype.Repository;
import writeside.domain.Room;
import writeside.domain.repo.RoomWriteRepo;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Repository
public class InMemoryRoomWriteRepo implements RoomWriteRepo {

    private final Collection<Room> rooms = Set.of(
            new Room("1", 4),
            new Room("2", 4),
            new Room("3", 3)
    );

    @Override
    public Optional<Room> find(String roomNumber) {
        return rooms.stream()
                .filter(r -> r.roomNumber().equals(roomNumber))
                .findFirst();
    }
}
