# Secret Escapes code challenge

Simulate a basic payment web application in Java 

## Getting Started

The task is to simulate a transfer of payments between accounts.
The rules for the task are discussed in the assignment and will not be displayed here

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
