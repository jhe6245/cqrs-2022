package writeside.domain.repo;

import writeside.domain.Room;

import java.util.Optional;

public interface RoomWriteRepo {

    Optional<Room> find(String roomNumber);
}
