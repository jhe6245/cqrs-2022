package writeside.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Booking {

    private String bookingNo;
    private String customer;
    private LocalDateTime from;
    private Duration length;
    private Room room;
    private boolean isCancelled;

    public Booking(String bookingNo, String customer, LocalDateTime from, Duration length, Room room) {
        this.bookingNo = bookingNo;
        this.customer = customer;
        this.from = from;
        this.length = length;
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
}
