# This is simple Spring Boot API using jdk 1.8

## Checklist for this practice

- [x] Run API locally
- [x] Connect to MongoDB local instance
- [x] Dockerize API
- [x] Unit testing
  - Junit5
- [x] Swagger File
- [ ] Error handling
- [ ] Logging
- [ ] Security (security access, basic auth, jwt, oauth2, etc)
- [ ] Practice dynamic replica scales with helm and kubernetes

## Run with docker
- `mvn clean package`
- `docker build -t users-api -f docker/Dockerfile .`
- `docker run -p 8080:8080 users-api`

## Run with only Spring Boot embedded tomcat server
- `mvn spring-boot:run `

## API Documentation
- [Swagger](http://localhost:8080/swagger-ui/index.html)