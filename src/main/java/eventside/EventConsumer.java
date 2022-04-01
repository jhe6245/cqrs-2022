package eventside;

import eventside.domain.Event;

public interface EventConsumer {

    Boolean consume(Event event);
}
