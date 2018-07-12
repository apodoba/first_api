FROM main-virtual.docker.vidible.aolcloud.net/main/openjdk-custom

ENV appName playlist-ng-server

COPY \
  target/first-api-0.0.1.jar /var/first-api/first-api-0.0.1.jar

WORKDIR /var/first-api
ENTRYPOINT ["java", "-jar", "first-api-0.0.1.jar"]
