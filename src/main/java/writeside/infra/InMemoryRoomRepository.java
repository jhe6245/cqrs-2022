package writeside.infra;

import org.springframework.stereotype.Repository;
import writeside.domain.Room;
import writeside.domain.repo.RoomRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryRoomRepository implements RoomRepository {

    private final Collection<Room> rooms
            = IntStream.range(1, 10)
            .mapToObj(i -> new Room(Integer.toString(i)))
            .collect(Collectors.toList());

    @Override
    public Optional<Room> find(String roomNumber) {
        return rooms.stream()
                .filter(r -> r.roomNumber().equals(roomNumber))
                .findFirst();
    }
}
