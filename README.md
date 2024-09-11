# Log Service Project with Load Balancer

## Project Summary

This project implements a Log Service with a Load Balancer using Spring Boot. The system is designed to efficiently handle log requests by distributing the load across multiple instances of the service.

## Architecture

The project consists of two main components:

1. **Log Service**: A Spring Boot service that handles logging operations.
2. **Load Balancer**: A component that uses the Round Robin algorithm to distribute requests among multiple Log Service instances.

The general architecture can be represented as follows:

![image](https://github.com/user-attachments/assets/6453fe34-4ea9-4f7a-a62c-c776c3ee2771)


## Class Design

The project is organized into the following main packages and classes:

### Package `edu.eci.arep.app`:

1. **`LogServiceApplication`**: Main class that starts the Spring Boot application for the log service.
2. **`AppConfig`**: Application configuration, including properties for MongoDB connection.
3. **`WebConfig`**: CORS configuration to allow requests from any origin.
4. **`LogController`**
5. **`LogEntry`**
6. **`LogRepository`**
7. **`MongoConfig`**

### Package `edu.eci.arep.app.RoundRobin`:

1. **`AppLbRoundRobinApplication`**: Main class for the load balancer application.
2. **`LoadBalancerController`**: (Not visible in the provided snippets) Presumably handles the load balancing logic.
3. **`WebController`**: Handles basic web requests, such as the home page.

## Generating Images and Deployment

To generate Docker images and deploy the project, follow these steps:

1. Make sure you have Docker installed on your system.

2. Navigate to the project's root directory.

3. Create a Dockerfile for the Log Service:

```dockerfile
FROM openjdk:17-jdk-alpine
COPY target/log-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

4. Create a Dockerfile for the Load Balancer:

```dockerfile
FROM openjdk:17-jdk-alpine
COPY target/load-balancer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

5. Build the Docker images:

```bash
docker build -t log-service:latest -f Dockerfile-LogService .
docker build -t load-balancer:latest -f Dockerfile-LoadBalancer .
```

6. Create a `docker-compose.yml` file to orchestrate the services:

```yaml
version: '3'
services:
  load-balancer:
    image: load-balancer:latest
    ports:
      - "8080:8080"
  log-service-1:
    image: log-service:latest
  log-service-2:
    image: log-service:latest
  log-service-3:
    image: log-service:latest
```

7. Start the services with Docker Compose:

```bash
docker-compose up
```

## Testing and Deployment

Once deployed, you can access the Load Balancer at `http://localhost:8080`. 



To test the load balancing, make multiple requests to the logging endpoint. You should see the requests being distributed among the different Log Service instances.

## Conclusions

This project demonstrates the implementation of a scalable logging system using Spring Boot and a load balancer with a Round Robin algorithm. The architecture allows for easy expansion by adding more Log Service instances as needed.
