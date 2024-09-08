package edu.escuelaing.arep.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.arep.model.LogMessage;
import edu.escuelaing.arep.repository.LogMessageRepository;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * The LogController class is a REST controller responsible for handling
 * HTTP requests related to logging messages. It allows users to submit log 
 * messages and retrieves the most recent log entries.
 */
@RestController
@RequestMapping("/logservice")
public class LogController {

    @Autowired
    private LogMessageRepository repository;

    /**
     * Handles HTTP POST requests to the /logservice/log endpoint.
     * This method creates a log entry with the provided message, assigns the 
     * current date and time in the Bogota time zone, and saves it to the repository.
     * It then retrieves and returns the latest 10 log entries, ordered by date in 
     * descending order.
     *
     * @param message The log message submitted by the user via the request.
     * @return A list of the 10 most recent LogMessage objects, ordered by date in descending order.
     */
    @PostMapping("/log")
    public List<LogMessage> logMessage(@RequestParam("message") String message) {
        LogMessage log = new LogMessage();
        log.setMessage(message);

        ZonedDateTime dateTimeInBogota = ZonedDateTime.now(ZoneId.of("America/Bogota")).minusHours(5);;
        log.setDate(Date.from(dateTimeInBogota.toInstant()));
        
        repository.save(log);

        return repository.findTop10ByOrderByDateDesc();
    }
}
