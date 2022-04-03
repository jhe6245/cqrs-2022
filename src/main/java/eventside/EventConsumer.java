package eventside;

import eventside.domain.Event;

public interface EventConsumer {

    Boolean subscribe(String publisher);

    Boolean consume(Event event);
}
