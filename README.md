# Secret Escapes code challenge

Simulate a basic payment web application in Java 

## Getting Started

The task objective is the following:

* Tasks can be postponed with a "remind me at" date for later.
* A scheduler should create new tasks at a random interval
* Tasks should be persisted in the database and should have, at least, the
following fields
  * id (uuid)
  * createdAt
  * updatedAt
  * dueDate
  * resolvedAt
  * title
  * description
  * priority
  * status
* REST Endpoints for communication with the Frontend
* For communication with the frontend, DTOs should be used
* Load the tasks from the backend asynchronously and list them according to
their dueDate and the priority
* If new tasks come in, they should be automatically added to the list of tasks
without the need to manually refresh the page

### Building

To install the sample using Maven, you can use the following Maven command from the root folder of the project

```
mvn install
```

### Running

To run the application in a docker container, navigate to the root folder of the project

```
docker-compose up

```

To run the application with maven use

```
mvn spring-boot:run

```

The application should run from [http://localhost:8080](http://localhost:8080)

The user views a list of pre-generated accounts. All accounts start with a balance of 200:
* From the accounts page he can choose to: 
![Homepage](/docs/transfer-nav.png?raw=true "Homepage")
* transfer an amount between accounts. This creates a new transaction and an email message to both parties
![Transfer](/docs/transfer.png?raw=true "Delete")
* He can view transactions for the transferring party
![View Transactions](/docs/transactions-nav.png?raw=true "Transactions")
* Transactions
![Transactions](/docs/transactions-nav.png?raw=true "Transactions")
* He can view messages for both parties
![View Messages](/docs/messages-nav.png?raw=true "Transactions")
* Messages
![Messages](/docs/messages-nav.png?raw=true "Transactions")

## Running the tests

To just run the test packages with Maven, run the following command

```
mvn test
```

## Built With

* [Java](https://www.java.com/) - The language of choice
* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Primefaces](https://www.primefaces.org/) - The jsf framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - Container service to run the application

## Documentation

The javadoc for this project can be found [here](https://boccob78.github.io/Paymentmanager)

## Authors

* **Farzan Zubair** 
