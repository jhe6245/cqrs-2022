package readside.domain;

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
}
