package readside.domain;

public class Booking {

    private String bookingNo;

    private String customer;

    public Booking(String bookingNo, String customer) {
        this.bookingNo = bookingNo;
        this.customer = customer;
    }

    public String bookingNo() {
        return bookingNo;
    }

    public String customer() {
        return customer;
    }
}
