package edu.escuelaing.arep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogServiceApplicationTest {

    @Test
    public void testGetPortDefault() {
        int defaultPort = LogServiceApplication.getPort();
        assertEquals(8080, defaultPort);
    }

    @Test
    public void testGetPortFromEnv() {
        System.setProperty("PORT", "9090");   
        int port = LogServiceApplication.getPort();
        assertEquals(9090, port);
        System.clearProperty("PORT");
    }
}

