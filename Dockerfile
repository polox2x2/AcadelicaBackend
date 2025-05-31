#Imagen oficial Del JDK17
FROM openjdk:17-jdk-slim

#Establece el directorio

WORKDIR / app

#Copia el JAR Compilado al contenedor
COPY target/proyecto-0.0.1-SNAPSHOT.jar app.jar

#Expone el puerto  de la aplicacion
EXPOSE 8080

#EJECUTAR LA APLICACION SPRING BOOT
ENTRYPOINT ["java","-jar","app.jar"]


