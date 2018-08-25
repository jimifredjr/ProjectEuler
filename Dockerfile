FROM java:8
VOLUME /tmp
COPY build/libs/project-euler-0.1.0.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]