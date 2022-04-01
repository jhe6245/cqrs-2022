package readside;

import eventside.EventConsumer;
import eventside.domain.Event;
import org.springframework.stereotype.Component;
import readside.repo.BookingReadRepo;
import readside.repo.RoomReadRepo;

@Component
public class EventConsumerImpl implements EventConsumer {

    private BookingReadRepo bookings;
    private RoomReadRepo rooms;

    @Override
    public Boolean consume(Event event) {
        bookings.consume(event);
        return true;
    }
}
