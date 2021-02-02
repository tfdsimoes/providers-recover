# Get Providers

## Introduction

This is a simple exercise to recover data from the database and save the data recover to a file.

All the commands present are for linux system.

## Requirements

To run the program there is the need to have Java 11, Docker and Docker-Compose installed.

Maven is not necessary since there is Maven Wrapper already in the project.

## Building \ Preparation

### Preparing the jar
To build the project and created the jar file you need to run the following command in the root of the project ```./mvnw clean package```. The command will generate a folder target in the root of the project.

### Preparing the DB

The DB used is MySql.
To start the DB in the root of the project just do ```docker-compose up``` these will start the MySql server and adminer a program to manage the database. 

After everything is up go to the following url http://localhost:8080/?server=db&username=root&sql= and insert the username root and password admin.
These will open a SQL executor. Copy the code in the script.sql and paste in there to generate the DB and insert the providers.

## How to run

To run the application just need to go to the target folder, that is generated after you package the project, and do ```java -jar providers-0.1.0 {idClient}``` change the idClient to the one you desire.

The file with the results will be generated on the folder you run the program. If everything goes well it will give tha absolute path of the file otherwise will give a message saying there were no results.

## Libs

| Lib | Usage |
| --- | --- |
| spring-boot-starter| Starter for running the applications with Spring Boot |
| spring-boot-data-jpa| Part of the larger Spring Data family, makes it easy to easily implement JPA based repositories |
| spring-boot-starter-test | Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito
| mysql-connector-java |  Connector of MySql to used wit Java|

## Documentation

All important functions implemented are documented using javadoc

## Tests

There is a small test cass that checks if the validator of arguments is working correct.

## Notes

Table of providers:
```
id int (PK)
name varchar
inserted datetime (timestamp on creation)
id_client int
```

Providers in the script:
```
1, Coca-cola, dd/mm/yyyy,5
2, Pepsi, dd/mm/yyyy, 5
3, Redbull, dd/mm/yyyy, 6
```