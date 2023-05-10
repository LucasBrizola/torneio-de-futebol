# torneio-de-futebol

Final Project designed to Fundatec's Conclusion Course. This is the backend.

Project made with Java Quarkus and connection with Atlas MongoDB.

IntelliJ has a Plugin called Quarkus Run Configs, which allows to run the project through the IDE instead of command lines.

## Endpoints:
See project Torneio-de-futebol-postman for requests with body examples
 
  Team:
```
POST localhost:8080/teams - create Team
POST localhost:8080/teams/team/{name} - addPlayer to Team
GET localhost:8080/teams - findAll
GET localhost:8080/teams/{name} - findByName
PUT localhost:8080/teams/{name} - update Team
DELETE localhost:8080/teams/{name} - deleteByName
```
  Match:
```
POST localhost:8080/matches - create Match
GET localhost:8080/matches - findAll
GET localhost:8080/matches/{name} - findByName
PUT localhost:8080/matches/{name} - update Match
PATCH localhost:8080/matches/{name} - update goals from Match
DELETE localhost:8080/matches/{name} - deleteByName
```
  User:
```
POST localhost:8080/user - Login
```
This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/torneio-de-futebol-1.0.0-SNAPSHOT-runner`
