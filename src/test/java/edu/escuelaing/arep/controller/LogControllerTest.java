package edu.escuelaing.arep.controller;

import edu.escuelaing.arep.model.LogMessage;
import edu.escuelaing.arep.repository.LogMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LogControllerTest {

    @Mock
    private LogMessageRepository repository;

    @InjectMocks
    private LogController logController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogMessage() {
        LogMessage log1 = new LogMessage();
        log1.setMessage("Test log 1");
        log1.setDate(new Date());
        
        LogMessage log2 = new LogMessage();
        log2.setMessage("Test log 2");
        log2.setDate(new Date());

        List<LogMessage> logs = Arrays.asList(log1, log2);
        
        when(repository.findTop10ByOrderByDateDesc()).thenReturn(logs);

        List<LogMessage> result = logController.logMessage("Test log");


        assertEquals(2, result.size());
        assertEquals("Test log 1", result.get(0).getMessage());
    }
}
