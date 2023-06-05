# Gateway server and Eureka discovery server

## Requirements
Java: 11

Maven: 3.8 

## Build code Spring Boot by Maven
```
mvn clean package
```

## Run application with docker

```bash
docker-compose up --build -d
```
## Result 
Run service example after run gateway and registry. Port gateway use in 8050.
Check <host>:8050/ex1/tutorials?user=user1&key=<*****>

