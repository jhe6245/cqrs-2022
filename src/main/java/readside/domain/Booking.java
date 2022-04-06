package readside.domain;

import java.util.Objects;

public class Booking {

    private String bookingNo;

    private String customer;

    public Booking(String bookingNo, String customer) {
        this.bookingNo = bookingNo;
        this.customer = customer;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingNo, booking.bookingNo) && Objects.equals(customer, booking.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingNo, customer);
    }
}
