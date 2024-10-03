FROM amazoncorretto:21

ENV TZ=Asia/Seoul

COPY build/libs/backend-0.0.1-SNAPSHOT.jar /srv/backend.jar

ENTRYPOINT ["java", "-jar", "/srv/backend.jar"]