

# **Travel Expenses Application**

This is a simple **Travel Expenses** application that demonstrates how to use **AMQP (Advanced Message Queuing Protocol)** for communication between a **Producer** module and a **Consumer** module using **RabbitMQ**. The application allows submitting travel expense requests and processing them for approval.

The project consists of two modules:
- **travel-expenses-producer**: This module is responsible for submitting travel expense requests to a RabbitMQ queue.
- **travel-expenses-consumer**: This module listens to the RabbitMQ queue and processes the expense requests for approval or rejection.

This open-source project is created to showcase the integration between **Spring Boot**, **AMQP**, and **RabbitMQ**.

## Project Structure

Here is an overview of the structure of the root project:

```
travel-expenses/
├── travel-expenses-producer/
│   ├── src/
│   ├── build.gradle
│   
├── travel-expenses-consumer/
│   ├── src/
│   ├── build.gradle
│   
├── build.gradle
└── settings.gradle
├── README.txt
└── LICENSE
```

- **travel-expenses-producer**: Contains the producer module that sends travel expense requests to the RabbitMQ queue.
- **travel-expenses-consumer**: Contains the consumer module that listens for incoming messages from RabbitMQ and processes them.
- **README.txt**: This file, providing an overview of the entire project.
- **LICENSE**: The project license file (GNU General Public License v3.0).

## Prerequisites

To get started with this project, make sure you have the following prerequisites:

- **Java 17** or higher: Required for building and running the Spring Boot applications.
- **RabbitMQ**: Used for message queuing between the producer and consumer modules.

### How to Install RabbitMQ:
1. You can install RabbitMQ by following the official installation guide here: [RabbitMQ Installation](https://www.rabbitmq.com/download.html).
2. Alternatively, you can use Docker to run RabbitMQ:
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```
3. Once RabbitMQ is running, you can access the RabbitMQ management interface at:
   ```
   http://localhost:15672
   ```
    - Username: `guest`
    - Password: `guest`

## How to Build and Run the Application

### Step 1: Clone the Repository

Clone the root repository to your local machine:

```bash
git clone https://github.com/your-username/travel-expenses.git
cd travel-expenses
```

### Step 2: Build the Application

Make sure you have **Gradle 8.1** or higher installed. You can follow the instructions here: [Gradle Installation](https://gradle.org/install/).

For building the project, navigate to the root directory and use the following command:

```bash
./gradlew build
```

This will build both the producer and consumer modules.

### Step 3: Run the Producer and Consumer

1. To run the **Producer** module (which sends travel expense requests to RabbitMQ), navigate to the `travel-expenses-producer` directory and run:

   ```bash
   ./gradlew bootRun
   ```

2. To run the **Consumer** module (which listens to the RabbitMQ queue and processes messages), navigate to the `travel-expenses-consumer` directory and run:

   ```bash
   ./gradlew bootRun
   ```

The producer will send requests to RabbitMQ, and the consumer will process these requests.

### Step 4: Ensure RabbitMQ is Running

Before running the applications, make sure RabbitMQ is running. You can verify this by accessing the RabbitMQ management interface at:

```
http://localhost:15672
```

- Username: `guest`
- Password: `guest`

If RabbitMQ is not running, start it using Docker as shown in the **Prerequisites** section or follow the installation guide.

---

## How the Application Works

1. **Producer Module** (`travel-expenses-producer`):
    - Sends travel expense requests to a RabbitMQ queue (`travel-expenses-request-queue`).
    - This module uses Spring Boot with AMQP to send messages to RabbitMQ.

2. **Consumer Module** (`travel-expenses-consumer`):
    - Listens for incoming messages from RabbitMQ (from the queue `travel-expenses-request-queue`).
    - Processes the travel expense requests by calling the relevant processing service.
    - If the message is processed successfully, it logs the result (e.g., approval or rejection).

The producer and consumer work together using RabbitMQ as the communication medium.

---

## How to Test the Application

1. **Run the Producer**:  
   The producer will send messages to the RabbitMQ queue when it is running. You can simulate sending a travel expense request by triggering the producer module to send a message to the queue.

2. **Check RabbitMQ Queue**:  
   Log into the RabbitMQ management interface at `http://localhost:15672`, and you should see the queue `travel-expenses-request-queue` where the messages are being published.

3. **Run the Consumer**:  
   The consumer will automatically pick up messages from the queue and process them. You will see logs indicating that the expense request has been processed.

4. **Check Logs**:  
   In the consumer application, check the logs to verify that the requests are being processed. If the request was successfully processed, you will see confirmation logs in the output.

---

## Open Source Project Maintained By

This open-source project is maintained by **[Aditya Pratap Bhuyan](https://linkedin.com/in/adityabhuyan)**. Feel free to reach out for contributions, bug reports, or questions.

---

## License

This project is licensed under the **GNU General Public License v3.0**. See the LICENSE file for more details.

---

