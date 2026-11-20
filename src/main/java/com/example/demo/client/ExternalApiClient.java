package com.example.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
public class ExternalApiClient {
    private final RestClient restClient;

    public ExternalApiClient(RestClient externalRestClient) {
        this.restClient = externalRestClient;
    }

    public <T> T get(String path, Class<T> responseType) {
        log.info("Calling external API with GET");
        return restClient.get().uri(path).retrieve().body(responseType);
    }

    public <T, R> T post(String path, R request, Class<T> responseType) {
        log.info("Calling external API with POST");
        return restClient.post().uri(path).body(request).retrieve().body(responseType);
    }
}
