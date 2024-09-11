package edu.eci.arep.app.RoundRobin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class LoadBalancerController {
    private final String[] logServices = {
            "http://logservice1:8080/log/entries",
            "http://logservice2:8080/log/entries",
            "http://logservice3:8080/log/entries"
    };
    private final AtomicInteger counter = new AtomicInteger(0);
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/log")
    public ResponseEntity<String> postLog(@RequestBody String message) {
        System.out.println("Received message: " + message);
        int index = counter.getAndIncrement() % logServices.length;
        String url = logServices[index];
        System.out.println("Sending message to " + url);
        try {
            String response = restTemplate.postForObject(url, message, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the error and return an error response
            System.err.println("Error sending request to " + url + ": " + e.getMessage());
            return ResponseEntity.internalServerError().body("Error processing request");
        }
    }
}