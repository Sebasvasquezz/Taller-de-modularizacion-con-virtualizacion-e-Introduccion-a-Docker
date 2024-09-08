package edu.escuelaing.arep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.arep.service.LoadBalancer;

/**
 * The AppController class is a REST controller responsible for handling 
 * HTTP requests related to the application. This controller exposes 
 * an endpoint to submit messages via HTTP POST requests.
 */

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private LoadBalancer loadBalancer;

     /**
     * Handles HTTP POST requests to the /app/submit endpoint.
     * This method accepts a message as a parameter and sends it to the
     * load balancer service.
     *
     * @param message The message submitted by the user via the request.
     * @return A String containing the response from the load balancer after processing the message.
     */
    @PostMapping("/submit")
    public String submitMessage(@RequestParam("message") String message) {
        String url= loadBalancer.getNextUrl();
        return loadBalancer.sendRequest(url, message);
    }
    
}
