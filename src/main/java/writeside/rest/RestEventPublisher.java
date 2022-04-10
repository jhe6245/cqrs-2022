package writeside.rest;

import eventside.EventPublisher;
import eventside.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestEventPublisher implements EventPublisher {

    private final WebClient localApiClient = WebClient.create("http://localhost:8080");

    public Boolean publishEvent(Event event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/publish")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
