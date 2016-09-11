FROM anapsix/alpine-java:8
EXPOSE 8080
COPY build/libs/*.jar /jar.jar
CMD ["java","-jar","/jar.jar"]
