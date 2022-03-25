package writeside.domain;

import eventside.domain.Event;

public interface EventPublisher {
    Boolean publishEvent(Event event);
}
