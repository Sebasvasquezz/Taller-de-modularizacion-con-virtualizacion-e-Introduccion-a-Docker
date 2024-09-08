package edu.escuelaing.arep.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LoadBalancerTest {

    @InjectMocks
    private LoadBalancer loadBalancer;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetNextUrl() {

        String url1 = loadBalancer.getNextUrl();
        String url2 = loadBalancer.getNextUrl();
        String url3 = loadBalancer.getNextUrl();
        String url4 = loadBalancer.getNextUrl();

        assertEquals("http://logservice1:6000/logservice/log", url1);
        assertEquals("http://logservice2:6000/logservice/log", url2);
        assertEquals("http://logservice3:6000/logservice/log", url3);
        assertEquals("http://logservice1:6000/logservice/log", url4);
    }
}

