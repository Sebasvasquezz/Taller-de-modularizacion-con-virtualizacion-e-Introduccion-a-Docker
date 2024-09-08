package edu.escuelaing.arep.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.arep.model.LogMessage;

import java.util.List;

/**
 * The LogMessageRepository interface extends MongoRepository and provides
 * methods to perform CRUD operations on LogMessage documents stored in MongoDB.
 * It also includes a custom query to retrieve the 10 most recent log messages.
 */
public interface LogMessageRepository extends MongoRepository<LogMessage, String> {
    /**
     * Retrieves the top 10 most recent log messages, ordered by their date 
     * in descending order (most recent first).
     *
     * @return A list of the 10 most recent LogMessage objects.
     */
    List<LogMessage> findTop10ByOrderByDateDesc();
}
