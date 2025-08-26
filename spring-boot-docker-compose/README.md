# spring-boot-docker-compose

Source code in relation to blog post: [How to deploy locally with no fuss using spring-boot-docker-compose](https://dev.to/migrosonline/how-to-deploy-locally-with-no-fuss-using-spring-boot-docker-compose-4a88-temp-slug-7300696).

## Pre-requisites

- Maven 3.x+
- Java 21.x+

## Environment Variables

```bash
export DATABASE_PASSWORD=Str0ngP4ssword
export RABBIT_PASSWORD=Str0ngP4ssword
```

## Build & Launch

```bash
mvn clean package
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=LOCAL"
```
