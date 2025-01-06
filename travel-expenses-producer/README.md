

# **Travel Expenses Producer Module**

This is the **Producer Module** for the Travel Expenses application, which demonstrates the use of **AMQP (Advanced Message Queuing Protocol)** with **Spring Boot** and **RabbitMQ**. The producer module is responsible for sending travel expense request messages to a RabbitMQ queue. The `travel-expenses-consumer` module will process these requests.

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **RabbitMQ** (The producer module interacts with RabbitMQ to send messages)

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

Here's a brief overview of the directory structure and key files in the **`travel-expenses-producer`** module:

```
travel-expenses-producer/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── travel/
│       │           └── producer/
│       │               ├── TravelExpenseProducerApplication.java
│       │               └── TravelExpenseService.java
│       │               └── TravelExpenseController.java
│       │               └── RabbitConfig.java
│       └── resources/
│           └── application.yml
├── build.gradle
└── settings.gradle
```

### Description of Key Files:

- **TravelExpenseProducerApplication.java**:  
  This is the entry point of the application. The class is annotated with `@SpringBootApplication`, which tells Spring Boot to auto-configure the application, run the application, and set up components like RabbitMQ connectivity.

- **TravelExpenseService.java**:  
  This service class is responsible for sending messages to the RabbitMQ queue. It uses the `RabbitTemplate` to send travel expense request messages to the queue (`travel-expenses-request-queue`).

- **TravelExpenseController.java**:  
  This controller class defines a REST endpoint to send a test request to the RabbitMQ queue. It uses the `TravelExpenseService` to send the request.

- **RabbitConfig.java**:
  This configuration class defines the connection factory, message converter, and RabbitTemplate bean to interact with RabbitMQ. It also specifies the queue name (`travel-expenses-request-queue`).

- **application.yml**:  
  This configuration file defines the connection details for RabbitMQ and specifies the name of the request queue (`travel-expenses-request-queue`).

- **build.gradle**:  
  This file includes the necessary dependencies for the Spring Boot application and the AMQP library to interact with RabbitMQ. It also defines tasks for building and running the application.

## How to Run the Application

### Step 1: Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/travel-expenses.git
cd travel-expenses/travel-expenses-producer
```

### Step 2: Build the Application

Make sure you have **Gradle 8.1** or higher installed. If you don't have Gradle, you can follow the installation instructions here: [Gradle Installation](https://gradle.org/install/).

To build the application, run:

```bash
./gradlew build
```

### Step 3: Run the Application

To start the producer application, use:

```bash
./gradlew bootRun
```

The application will start on **port 8081** (as defined in `application.yml`).

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

To test the producer module:

1. **Send a Test Request**:  
   The producer sends messages to RabbitMQ's `travel-expenses-request-queue`. You can simulate sending a request by calling the `submitExpenseRequest()` method in the `TravelExpenseService`.

   Here's an example of how you could call it in a `CommandLineRunner` bean to send a test request:

   ```java
   @SpringBootApplication
   public class TravelExpenseProducerApplication implements CommandLineRunner {
       private final TravelExpenseService travelExpenseService;

       @Autowired
       public TravelExpenseProducerApplication(TravelExpenseService travelExpenseService) {
           this.travelExpenseService = travelExpenseService;
       }

       public static void main(String[] args) {
           SpringApplication.run(TravelExpenseProducerApplication.class, args);
       }

       @Override
       public void run(String... args) throws Exception {
           travelExpenseService.submitExpenseRequest("Request for Travel to Paris");
       }
   }
   ```

2. **Check RabbitMQ Queue**:  
   After running the application, check the `travel-expenses-request-queue` in RabbitMQ’s management interface to verify that the message was sent successfully.

3. **Check Logs**:  
   You should see the following log output indicating that the expense request was sent:

   ```
   Sent expense request: Request for Travel to Paris
   ```

---

## Open Source Project Maintained By

This open-source project is maintained by **[Aditya Pratap Bhuyan](https://linkedin.com/in/adityabhuyan)**. Feel free to reach out for contributions, bug reports, or questions.

---

## License

This project is licensed under the **GNU General Public License v3.0**. See the LICENSE file for more details.

---
