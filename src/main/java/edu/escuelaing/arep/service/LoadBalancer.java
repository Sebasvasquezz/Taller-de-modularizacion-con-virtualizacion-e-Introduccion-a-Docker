package edu.escuelaing.arep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The LoadBalancer class is a service responsible for distributing incoming
 * requests across multiple log service instances. It uses a round-robin algorithm
 * to balance the load among the different log services.
 */
@Service
public class LoadBalancer {
    private int currentIndex = 0;
    private final String[] logServiceUrls = {
        "http://logservice1:6000/logservice/log",
        "http://logservice2:6000/logservice/log",
        "http://logservice3:6000/logservice/log"
    };

    /**
     * Returns the next URL in the round-robin sequence.
     * 
     * @return The URL of the next log service to use.
     */
    public String getNextUrl() {
        String url = logServiceUrls[currentIndex];
        currentIndex = (currentIndex + 1) % logServiceUrls.length; 
        return url;
    }

    /**
     * Sends the given log message to the specified log service URL.
     *
     * @param url     The URL of the log service.
     * @param message The log message to be sent.
     * @return The response received from the log service.
     */
    public String sendRequest(String url, String message) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url + "?message=" + message, null, String.class);
    }

    /**
     * Wrapper method that combines both the round-robin URL selection and the request sending.
     * 
     * @param message The log message to be sent.
     * @return The response received from the log service.
     */
    public String sendRequestWithRoundRobin(String message) {
        String url = getNextUrl();
        return sendRequest(url, message);
    }
}