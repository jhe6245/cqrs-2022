package eventside;

import eventside.domain.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();
    private final Set<EventConsumer> consumers = new HashSet<>();

    public void addSubscriber(EventConsumer consumer) {
        consumers.add(consumer);
    }

    public void processEvent(Event event) {
        events.add(event);
        consumers.forEach(c -> c.consume(event));
    }
}
