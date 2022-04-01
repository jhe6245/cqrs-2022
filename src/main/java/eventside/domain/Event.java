package eventside.domain;

import java.time.*;

public class Event {

    private final String bookingNo;
    private final String customer;
    private final LocalDateTime timestamp;
    private final EventType type;
    private final String room;
    private final LocalDateTime from;
    private final Duration duration;

    public Event(String bookingNo, String customer, LocalDateTime timestamp, EventType type, String room, LocalDateTime from, Duration duration) {
        this.bookingNo = bookingNo;
        this.customer = customer;
        this.timestamp = timestamp;
        this.type = type;
        this.room = room;
        this.from = from;
        this.duration = duration;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

    public EventType type() {
        return type;
    }

    public LocalDateTime from() {
        return from;
    }

    public Duration duration() {
        return duration;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public String getCustomer() {
        return customer;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }

    public String getType() {
        return type.toString();
    }

    public String getRoom() {
        return room;
    }

    public String getFrom() {
        return from.toString();
    }

    public String getDuration() {
        return duration.toString();
    }

    @Override
    public String toString() {
        return "Event{" +
                "bookingNo='" + bookingNo + '\'' +
                ", customer='" + customer + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", room='" + room + '\'' +
                ", from='" + from + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
