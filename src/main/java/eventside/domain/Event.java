package eventside.domain;

import java.time.*;

public class Event {

    private final String bookingNo;
    private final String customer;
    private final String timestamp;
    private final String type;
    private final String room;
    private final String from;
    private final String duration;

    public Event(String bookingNo, String customer, LocalDateTime timestamp, EventType type, String room, LocalDateTime from, Duration duration) {
        this.bookingNo = bookingNo;
        this.customer = customer;
        this.timestamp = timestamp.toString();
        this.type = type.toString();
        this.room = room;
        this.from = from.toString();
        this.duration = duration.toString();
    }

    public String type() {
        return type;
    }

    public String bookingNo() {
        return bookingNo;
    }

    public String customer() {
        return customer;
    }

    public String timestamp() {
        return timestamp;
    }

    public String room() {
        return room;
    }

    public String from() {
        return from;
    }

    public String duration() {
        return duration;
    }
}
