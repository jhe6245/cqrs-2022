package eventside.rest;

import eventside.EventConsumer;
import eventside.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RestEventConsumer implements EventConsumer {

    private final WebClient localApiClient;

    public RestEventConsumer(String uri) {
        localApiClient =  WebClient.create(uri);
    }

    @Override
    public Boolean consume(Event event) {
        return localApiClient
                .post()
                .uri("/consume-event/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event),Event.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
