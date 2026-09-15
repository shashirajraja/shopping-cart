FROM maven:3.9-eclipse-temurin-8 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
COPY WebContent ./WebContent
RUN mvn clean package

FROM tomcat:9-jdk8

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /app/target/*.war \
    /usr/local/tomcat/webapps/shopping-cart.war

EXPOSE 8080

CMD ["catalina.sh", "run"]