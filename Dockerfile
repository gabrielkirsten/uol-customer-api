FROM openjdk:8
VOLUME /target
COPY target/customer-api-*.jar customer-api.jar
ENTRYPOINT ["java", "-jar", "/customer-api.jar"]
