# momentum

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
