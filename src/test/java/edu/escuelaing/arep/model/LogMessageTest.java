package edu.escuelaing.arep.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogMessageTest {

    @Test
    public void testLogMessage() {
        LogMessage logMessage = new LogMessage();
        String message = "Test log message";
        Date date = new Date();

        logMessage.setMessage(message);
        logMessage.setDate(date);

        assertEquals(message, logMessage.getMessage());
        assertEquals(date, logMessage.getDate());
    }
}
