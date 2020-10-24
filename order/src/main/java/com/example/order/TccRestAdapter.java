package com.example.order;

import java.net.URI;
import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class TccRestAdapter {
    private final RestTemplate restTemplate = new RestTemplate();

    public ParticipantLink doTry(String requestUri, Map<String, Object> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ParticipantLink> response = restTemplate.postForEntity(requestUri,
            new HttpEntity<>(requestBody, headers), ParticipantLink.class);

        if (response.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }

        return response.getBody();
    }

    public void confirmAll(URI... uris) {
        Arrays.stream(uris).forEachOrdered(uri -> {
            try {
                restTemplate.put(uri, null);
            } catch (RestClientException e) {
                throw new RuntimeException();
            }
        });
    }

    public void cancelAll(URI... uris) {
        Arrays .stream(uris).forEachOrdered(participantLink -> {
            try {
                restTemplate.delete(participantLink);
            } catch (RestClientException e) {
                throw new RuntimeException();
            }
        });
    }
}
