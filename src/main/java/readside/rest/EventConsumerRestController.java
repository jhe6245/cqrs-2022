package readside.rest;

import eventside.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import eventside.EventConsumer;

@RestController
public class EventConsumerRestController {
    @Autowired
    private EventConsumer consumer;

    @PostMapping(value = "/consume", consumes = "application/json", produces = "application/json")
    public void consume(@RequestBody Event event) {
        consumer.consume(event);
    }
}
