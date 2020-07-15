FROM maven:3.6.3-jdk-8 AS builder

ADD country-service /tmp/country-service
RUN mvn --batch-mode -f /tmp/country-service/pom.xml verify

ADD test-rest-service /tmp/test-rest-service
RUN mvn --batch-mode -f /tmp/test-rest-service/pom.xml verify

FROM tomcat:9-jdk8
COPY --from=builder /tmp/country-service/target/*.war /usr/local/tomcat/webapps
COPY --from=builder /tmp/test-rest-service/target/*.war /usr/local/tomcat/webapps
ADD json-processing-webapp-2.25.war /usr/local/tomcat/webapps
ADD axis2.war /usr/local/tomcat/webapps
ADD index.html /usr/local/tomcat/webapps/ROOT/index.html
