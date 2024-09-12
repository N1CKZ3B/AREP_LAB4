# Log Service Project with Load Balancer

## Project Summary

This project implements a Log Service with a Load Balancer using Spring Boot. The system is designed to efficiently handle log requests by distributing the load across multiple instances of the service.

## Architecture

The project consists of two main components:

1. **Log Service**: A Spring Boot service that handles logging operations.
2. **MongoDB**: Database which will store all data sent and will be able to store the data in each Log Service created
3. **app-lb-roundrobin** : code which will be able to perform the algorithm and balancing the data storage between the three log services created

The general architecture can be represented as follows:

![image](https://github.com/user-attachments/assets/6453fe34-4ea9-4f7a-a62c-c776c3ee2771)


```
C:.
└───src
   ├───main
   │     ├───java
   │     │     └───edu
   │     │           └───eci
   │     │                  └───arep
   |     └───resources            └───app
   │     
   └───test
         └───java
                └───edu
                       └───eci
                            └───arep
                                  └───app
```

## Class Design

The project is organized into the following main packages and classes:

### Package `edu.eci.arep.app`:

1. **`LogServiceApplication`**: Main class that starts the Spring Boot application for the log service.
2. **`AppConfig`**: Application configuration, including properties for MongoDB connection.
3. **`WebConfig`**: CORS configuration to allow requests from any origin.
4. **`LogController`**: REST controller handling log-related HTTP requests. It provides endpoints for logging messages and retrieving log entries.
5. **`LogEntry`**: Model class representing a log entry. It's annotated for MongoDB document mapping and includes fields for the log message and timestamp.
6. **`LogRepository`**: An interface extending MongoRepository for handling CRUD operations on LogEntry objects. It includes a custom method to fetch the 10 most recent log entrie
7. **`MongoConfig`**: Configuration class for MongoDB connection. It sets up the MongoClient and MongoTemplate beans, specifying the MongoDB URI and database name.
8. **`MongoProperties`**: A configuration properties class for MongoDB settings. It allows for externalized configuration of MongoDB connection details.

### Package `edu.eci.arep.app.RoundRobin`:

1. **`AppLbRoundRobinApplication`**: Main class for the load balancer application.
2. **`LoadBalancerController`**: Handles the load balancing logic.
3. **`WebController`**: Handles basic web requests, such as the home page.

## Generating Images and Deployment

To generate Docker images and deploy the project, follow these steps:

1. Make sure you have Docker installed on your system.

```
docker --version
```
2. Clone the repository.
   
```
git clone https://github.com/N1CKZ3B/AREP_LAB4
```

3. Navigate to the folder:

```
cd AREP_LAB4
```

4. Run mvn package:

```
mvn package
```
5. execute docker compose:

```bash
docker-compose up -d
```

6. The docker images will be able to be seen in the app.
   
## Testing and Deployment

Once deployed, you can access the Load Balancer at `http://localhost:8080`. 


![image](https://github.com/user-attachments/assets/e0c9fc41-9aed-476d-9c66-88a374b11146)


To test the load balancing, make multiple requests to the logging endpoint. You should see the requests being distributed among the different Log Service instances.In this case along the log service executed in docker it is seen that each message is distributed equally amongst the three services.

Alongside here is the video that proves how it could be executed when run in a virtual machine on AWS:


https://github.com/user-attachments/assets/f577bb01-756c-4a81-84f4-07987f83270f


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Generating and storing images
* [EC2](https://aws.amazon.com/) - cloud and virtual machines

## Conclusions

This project demonstrates the implementation of a scalable logging system using Spring Boot and a load balancer with a Round Robin algorithm. The architecture allows for easy expansion by adding more Log Service instances as needed.

## Author

Nicolas Sebastian Achuri Macias
