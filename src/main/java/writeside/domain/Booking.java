package writeside.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Booking {

    private final String bookingNo;
    private final String customer;
    private final LocalDateTime from;
    private final Duration duration;
    private final Room room;
    private boolean isCancelled;

    public Booking(String bookingNo, String customer, LocalDateTime from, Duration duration, Room room) {
        this.bookingNo = bookingNo;
        this.customer = customer;
        this.from = from;
        this.duration = duration;
        this.room = room;
        this.isCancelled = false;
    }

    public void cancel() {
        if(isCancelled) {
            throw new UnsupportedOperationException("already cancelled");
        }
        isCancelled = true;
    }

    public String bookingNumber() {
        return bookingNo;
    }

    public String customer() {
        return customer;
    }

    public LocalDateTime from() {
        return this.from;
    }

    public Duration duration() {
        return duration;
    }

    public LocalDateTime until() {
        return from.plus(duration);
    }

    public Room room() {
        return room;
    }
}
