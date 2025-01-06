[]: # Title: Travel Expenses Consumer Module
[]: # Description: This is the Consumer Module for the Travel Expenses application, which demonstrates the use of AMQP (Advanced Message Queuing Protocol) with Spring Boot and RabbitMQ. The consumer module listens for travel expense request messages from the RabbitMQ queue and processes them accordingly.

# **Travel Expenses Consumer Module**

This is the **Consumer Module** for the Travel Expenses application, which demonstrates the use of **AMQP (Advanced Message Queuing Protocol)** with **Spring Boot** and **RabbitMQ**. The consumer module listens for travel expense request messages from the RabbitMQ queue and processes them accordingly.

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **RabbitMQ** (The consumer module listens for messages from RabbitMQ)

### How to Install RabbitMQ:
1. You can install RabbitMQ by following the official guide here: [RabbitMQ Installation](https://www.rabbitmq.com/download.html).
2. Alternatively, you can run RabbitMQ using Docker:
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```
3. After running RabbitMQ, you can access the RabbitMQ management interface at: `http://localhost:15672`
    - Username: `guest`
    - Password: `guest`

## Project Structure

Here's a brief overview of the directory structure and key files in the **`travel-expenses-consumer`** module:

```
travel-expenses-consumer/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── travel/
│       │           └── consumer/
│       │               ├── TravelExpenseConsumerApplication.java
│       │               ├── MessageListener.java
│       │               └── TRabbitConfig.java
│       └── resources/
│           └── application.yml
├── build.gradle
└── settings.gradle
```

### Description of Key Files:

- **TravelExpenseConsumerApplication.java**:  
  This is the entry point of the application. The class is annotated with `@SpringBootApplication`, which tells Spring Boot to auto-configure the application, run the application, and set up components like RabbitMQ connectivity and message listeners.

- **TRabbitConfig.java**:  
  This class contains the configuration for connecting to RabbitMQ. It defines the connection factory, message converter, and the listener container factory. The `@Configuration` annotation indicates that this class provides bean definitions for the application context.

- **MessageListener.java**:  
  This class listens for incoming messages from the RabbitMQ queue `travel-expenses-request-queue`. When a message is received, it triggers the corresponding method to process the expense request.

- **TravelExpenseProcessingService.java**:  
  This service class is responsible for processing the travel expense request messages. It contains the logic for approving or rejecting the travel expenses based on predefined criteria.

- **application.yml**:  
  This configuration file defines the connection details for RabbitMQ and specifies the name of the queue to listen to (`travel-expenses-request-queue`).

- **build.gradle**:  
  This file includes the necessary dependencies for the Spring Boot application and the AMQP library to interact with RabbitMQ. It also defines tasks for building and running the application.

## How to Run the Application

### Step 1: Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/travel-expenses.git
cd travel-expenses/travel-expenses-consumer
```

### Step 2: Build the Application

Make sure you have **Gradle 8.1** or higher installed. If you don't have Gradle, you can follow the installation instructions here: [Gradle Installation](https://gradle.org/install/).

To build the application, run:

```bash
./gradlew build
```

### Step 3: Run the Application

To start the consumer application, use:

```bash
./gradlew bootRun
```

The application will start on **port 8082** (as defined in `application.yml`).

### Step 4: Ensure RabbitMQ is Running

Before running the application, ensure that RabbitMQ is running. You can verify this by navigating to the RabbitMQ management interface at:

```
http://localhost:15672
```

- Username: `guest`
- Password: `guest`

If RabbitMQ is not running, start it using Docker as shown in the **Prerequisites** section or follow the installation guide.

---

## How to Test the Application

To test the consumer module:

1. **Ensure the Producer is Running**:  
   Before testing the consumer, make sure the `travel-expenses-producer` module is running and sending messages to RabbitMQ.

2. **Check RabbitMQ Queue**:  
   The consumer listens to the `travel-expenses-request-queue`. When a message is added to this queue by the producer, the consumer should automatically pick it up and process it.

3. **Check Logs**:  
   You should see log output indicating that the message was received and processed. For example, the log might show that a travel expense request was successfully processed and approved.

4. **Simulate a Test**:  
   To simulate a message being received by the consumer, you can send a test message to RabbitMQ. Here's an example of how to send a test message using the RabbitMQ management interface:

    - Navigate to `http://localhost:15672`
    - Go to the **Queues** tab and click on the `travel-expenses-request-queue`.
    - In the **Publish message** section, enter a test message (e.g., "Request for travel to Paris") and publish it.

5. **Message Processing**:  
   When the consumer picks up the message, it should log that it has received and processed the request. The exact behavior depends on how your message processing logic is designed (e.g., approve or reject based on certain criteria).

---

## Open Source Project Maintained By

This open-source project is maintained by **[Aditya Pratap Bhuyan](https://linkedin.com/in/adityabhuyan)**. Feel free to reach out for contributions, bug reports, or questions.

---

## License

This project is licensed under the **GNU General Public License v3.0**. See the LICENSE file for more details.

---

