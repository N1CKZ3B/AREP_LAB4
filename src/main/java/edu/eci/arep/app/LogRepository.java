package edu.eci.arep.app;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface LogRepository extends MongoRepository<LogEntry, String> {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}