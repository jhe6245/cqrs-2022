package readside;

import eventside.EventConsumer;
import eventside.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import readside.repo.BookingReadRepo;
import readside.repo.RoomReadRepo;


@Component
public class EventConsumerImpl implements EventConsumer {

    @Autowired
    private BookingReadRepo bookings;

    //@Autowired
    //private RoomReadRepo rooms;

    @Override
    public Boolean consume(Event event) {
        bookings.consume(event);
        return true;
    }

    @Override
    public Boolean subscribe(String publisher) {
        return WebClient.create(publisher)
                .get()
                .uri(uriBuilder -> uriBuilder.path("/subscribe").queryParam("uri", "http://localhost:8082").build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
