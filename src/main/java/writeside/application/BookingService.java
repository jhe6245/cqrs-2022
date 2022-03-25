package writeside.application;

import java.time.Duration;
import java.time.LocalDateTime;

public interface BookingService {
    void bookRoom(LocalDateTime from, Duration duration, String roomNumber, String customer);
    void cancel(String bookingNumber);
}
