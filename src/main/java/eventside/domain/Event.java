package eventside.domain;

import java.time.*;

public class Event {

    private final EventType type;
    private final LocalDateTime timestamp;

    private final String bookingNo;
    private final String customer;
    private final String room;

    private final LocalDateTime from;
    private final LocalDateTime until;

    public Event(EventType type, LocalDateTime timestamp, String bookingNo, String customer, String room, LocalDateTime from, LocalDateTime until) {
        this.type = type;
        this.timestamp = timestamp;
        this.bookingNo = bookingNo;
        this.customer = customer;
        this.room = room;
        this.from = from;
        this.until = until;
    }

    public EventType type() {
        return type;
    }

    public EventType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public String getCustomer() {
        return customer;
    }

    public String getRoom() {
        return room;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getUntil() {
        return until;
    }
}
