# spring-postgre-sample-app

---

### Build the JAR: 
Run the following in the root project directory:
```
mvn clean package
```


### Create Dockerfile
```
# Start with a base image
FROM openjdk:17-jdk-slim

# Add a volume to store logs
VOLUME /tmp

# Set the working directory
WORKDIR /app

# Create a variable to get JAR file name
ARG JAR_FILE=target/*.jar

# Copy the application JAR file
COPY ${JAR_FILE} app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

### Create docker-compose.yml file
```
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/app_db
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=password1

  db:
    image: postgres:15
    container_name: postgres
    ports:
      - "5432:5432"
    environment:
      POSTGRES_DB: app_db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password1
    volumes:
      - db_data:/var/lib/postgresql/data

volumes:
  db_data:

```

### Run Docker Compose:
Run the following in the root project directory:
```
docker-compose up --build
```

---

### Test the Application
Save a Name:
```
curl -X POST -H "Content-Type: application/json" -d '{"name":"John"}' http://localhost:8080/user
```

Get a Name:
```
curl http://localhost:8080/user/1
```

The response should be:
```
Hello, John!
```