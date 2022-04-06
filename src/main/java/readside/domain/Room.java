package readside.domain;

import java.util.Objects;

public class Room {

    private String roomNo;

    private int maxGuests;

    public Room(String roomNo, int maxGuests) {
        this.roomNo = roomNo;
        this.maxGuests = maxGuests;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return maxGuests == room.maxGuests && Objects.equals(roomNo, room.roomNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo, maxGuests);
    }
}
