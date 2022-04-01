package readside.domain;

public class Booking {

    private String bookingNo;

    public Booking(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String bookingNo() {
        return bookingNo;
    }
}
