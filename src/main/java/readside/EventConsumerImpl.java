package readside;

import eventside.domain.Event;
import readside.repo.BookingRepository;
import readside.repo.RoomRepository;

public class EventConsumerImpl implements EventConsumer {

    private BookingRepository bookings;
    private RoomRepository rooms;

    @Override
    public void consume(Event event) {
        switch(event.type()) {

        }
    }
}
