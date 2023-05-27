FROM openjdk:20
MAINTAINER linorman
ADD lite_mall_backend-0.0.1-SNAPSHOT.jar lite_mall_server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","lite_mall_server.jar"]
LABEL maintainer="linorman" \
    name="lite_mall_server" \
    version="1.0"
