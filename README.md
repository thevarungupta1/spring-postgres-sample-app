# spring-postgre-sample-app

---

### Build the JAR: 
Run the following in the root project directory:
```
mvn clean package
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