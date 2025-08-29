# spring-boot-docker-compose

Source code in relation to blog post: [How to run services locally with no fuss using spring-boot-docker-compose](https://dev.to/migrosonline/how-to-deploy-locally-with-no-fuss-using-spring-boot-docker-compose).

## Pre-requisites

- Java 21+

## Environment Variables

```bash
export DATABASE_PASSWORD=Str0ngP4ssword
export RABBIT_PASSWORD=Str0ngP4ssword
export KAFKA_PASSWORD=Str0ngP4ssword
```

## Build & Launch

```bash
./mvnw clean package
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=LOCAL"
```
