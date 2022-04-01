package readside;

import eventside.domain.Event;

public interface EventConsumer {

    void consume(Event event);
}
