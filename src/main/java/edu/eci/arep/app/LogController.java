package edu.eci.arep.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/log/entries")
public class LogController {
    private final LogRepository logRepository;
    private final MongoTemplate MongoTemplate;


        @Autowired
        public LogController(MongoTemplate mongoTemplate, LogRepository logRepository) {
            this.MongoTemplate = mongoTemplate;
            this.logRepository = logRepository;
        }

        @PostMapping
        public List<LogEntry> logMessage(@RequestBody String message) {
            System.out.println("Received message: " + message);
            LogEntry entry = new LogEntry(message, LocalDateTime.now());
            logRepository.save(entry);
            System.out.println("Saved entry: " + entry);
            return logRepository.findTop10ByOrderByTimestampDesc();
        }

        @GetMapping
        public String getEntries() {
            return "Hola";
        }
    }
