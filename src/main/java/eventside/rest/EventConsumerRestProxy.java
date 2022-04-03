package eventside.rest;

import eventside.EventConsumer;
import eventside.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class EventConsumerRestProxy implements EventConsumer {

    private final WebClient localApiClient;

    public EventConsumerRestProxy(String consumerRestUri) {
        localApiClient =  WebClient.create(consumerRestUri);
    }

    @Override
    public Boolean subscribe(String publisher) {
        return WebClient.create(publisher)
                .get()
                .uri("/subscribe")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    @Override
    public Boolean consume(Event event) {
        return localApiClient
                .post()
                .uri("/consume")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
