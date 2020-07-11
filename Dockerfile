FROM maven:3.6.3-jdk-8 AS builder

ADD country-service /tmp/country-service
RUN mvn -f /tmp/country-service/pom.xml verify

ADD test-rest-service /tmp/test-rest-service
RUN mvn -f /tmp/test-rest-service/pom.xml verify

ADD ivy-echo-service /tmp/ivy-echo-service
RUN mvn -f /tmp/ivy-echo-service/pom.xml verify

FROM tomcat:9-jdk8
COPY --from=builder /tmp/country-service/target/*.war /usr/local/tomcat/webapps
COPY --from=builder /tmp/test-rest-service/target/*.war /usr/local/tomcat/webapps
COPY --from=builder /tmp/ivy-echo-service/target/*.war /usr/local/tomcat/webapps
