# Usa Java 8 como base / uses java 8 as base
FROM openjdk:8-jdk-alpine

# Crea un directorio para la app / creates a directory for the app
WORKDIR /app

# Copia el jar ya construido al contenedor / copies the built jar in the container
COPY target/users-api.jar app.jar

# Exponer el puerto que usa la app / exposes the port used by the app
EXPOSE 8080

# Comando para ejecutar la app / cmd to app excecution
ENTRYPOINT ["java", "-jar", "app.jar"]