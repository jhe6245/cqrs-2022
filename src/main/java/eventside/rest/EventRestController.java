package eventside.rest;

import eventside.EventRepository;
import eventside.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @GetMapping(value = "/subscribe", produces = "application/json")
    public boolean subscribe(@RequestParam String uri) {
        repository.subscribe(new EventConsumerRestProxy(uri));
        System.out.println("Added subscriber: " + uri);
        return true;
    }

    @PostMapping(value = "/publish", consumes = "application/json", produces = "application/json")
    public boolean publish(@RequestBody Event event) {
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
