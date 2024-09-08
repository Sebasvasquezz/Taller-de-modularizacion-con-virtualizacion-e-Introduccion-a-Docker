package edu.escuelaing.arep;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The LogServiceApplication class is the entry point of the Spring Boot application.
 * It is responsible for configuring and starting the log service application. 
 * It also handles setting the server port, which can be dynamically determined 
 * based on an environment variable.
 */
@SpringBootApplication
public class LogServiceApplication {

	/**
     * The main method that serves as the entry point for the application.
     * It configures the application to run on a port specified by the 
     * environment variable "PORT" or defaults to port 8080 if the variable 
     * is not set.
     *
     * @param args The command-line arguments passed to the application.
     */
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LogServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);


    }

	 /**
     * Determines the port on which the application should run.
     * It first checks if the "PORT" environment variable is set. 
     * If it is, the value from the environment variable is used. 
     * Otherwise, it defaults to port 8080.
     *
     * @return The port number on which the application will run.
     */
	public static int getPort() {
        String port = System.getProperty("PORT", System.getenv("PORT"));
        if (port != null) {
            return Integer.parseInt(port);
        }
        return 8080;
    }
}