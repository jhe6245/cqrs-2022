package eventside;

import eventside.domain.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EventRepository {

    private List<Event> events = new ArrayList<>();
    private Set<EventConsumer> consumers = new HashSet<>();

    public void subscribe(EventConsumer consumer) {
        consumers.add(consumer);
    }

    public void processEvent(Event event) {
        events.add(event);

        for(EventConsumer c: consumers)
            c.consume(event);
    }
}
