package writeside.domain;

public class Room {

    private String roomNumber;

    private int maxGuests;

    public Room(String roomNumber, int maxGuests) {
        this.roomNumber = roomNumber;
        this.maxGuests = maxGuests;
    }

    public int maxGuests() {
        return maxGuests;
    }

    public String roomNumber() {
        return roomNumber;
    }
}
