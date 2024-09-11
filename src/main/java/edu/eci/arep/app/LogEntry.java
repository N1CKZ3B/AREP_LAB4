package edu.eci.arep.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class LogEntry {
    @Id
    private String id;
    private String message;
    private LocalDateTime timestamp;

    // Constructor sin argumentos (necesario para MongoDB)
    public LogEntry() {
    }


    @JsonCreator
    public LogEntry(@JsonProperty("message") String message, @JsonProperty("timestamp") LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
