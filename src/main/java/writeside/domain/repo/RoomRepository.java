package writeside.domain.repo;

import writeside.domain.Room;

import java.util.Optional;

public interface RoomRepository {

    Optional<Room> find(String roomNumber);
}
