# Distributed Log Service with Load Balancing

This project implements a distributed logging system using Docker containers running on AWS EC2. It consists of a web application with round-robin load balancing, multiple instances of a LogService, and a MongoDB database for persistence.

## Architecture Overview

- **Web Client**: A Bootstrap-based web interface for user interaction.
- **APP-LB-RoundRobin**: A load balancer implementing a Round Robin algorithm to distribute requests across LogService instances.
- **LogService**: Multiple instances (35001, 35002, 35003) of a REST service that logs messages and retrieves recent entries.
- **MongoDB**: A database service for storing logged messages.

All services run within Docker containers on an AWS EC2 instance.

## Components

![image](https://github.com/user-attachments/assets/26e956d7-3ded-47fb-a458-43333e782514)


### Web Client

- Provides a simple interface with an input field and a submit button.
- Sends user messages to the APP-LB-RoundRobin service.
- Displays the JSON response containing the 10 most recent log entries.

### APP-LB-RoundRobin

- REST service that receives messages from the web client.
- Implements a Round Robin load balancing algorithm.
- Distributes incoming requests across three LogService instances.

### LogService

- REST service with three instances (ports 35001, 35002, 35003).
- Receives a string message, stores it in MongoDB, and returns a JSON object.
- The JSON response includes the 10 most recent messages with their timestamps.

### MongoDB

- NoSQL database running in a Docker container.
- Stores the logged messages and their timestamps.

## Getting Started

### Prerequisites

- AWS account with EC2 access
- Docker and Docker Compose
- Git

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/Erick01081/Lab4_Arep.git
   ```

2. Navigate to the project directory:
   ```
   cd Lab4_Arep
   ```

3. Build and run the Docker containers:
   ```
   docker-compose up -d
   ```

4. Access the web application:
   Open a web browser and navigate to `http://localhost:8080`

## Usage

![image](https://github.com/user-attachments/assets/cb88268c-2476-4b84-a0d7-3256380c3aaa)

![VideoArep1](https://github.com/user-attachments/assets/40ca54b7-96da-40fe-a4cf-1b8652993d29)



1. Enter a message in the input field on the web page.
2. Click the submit button to send the message.
3. The page will update with the 10 most recent log entries in JSON format.

## Development

To modify or extend the project:

1. Update the relevant Docker service in `docker-compose.yml`.
2. Rebuild the affected containers:
   ```
   docker-compose up -d --build [service name]
   ```

## Testing

https://github.com/user-attachments/assets/4912bdcc-fd88-4654-aff5-0e5ada213bd7

## Deployment

The application is designed to run on AWS EC2. Ensure that the EC2 instance has the necessary security group settings to allow inbound traffic on the required ports.

## Built With

- Docker - Containerization platform
- Node.js - Runtime for APP-LB-RoundRobin and LogService
- MongoDB - Database for message storage
- Bootstrap - Front-end framework for the web client


## Authors

Erick Montero https://github.com/Erick01081




