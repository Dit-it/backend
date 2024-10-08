#!/usr/bin/env bash

# build gradle
chmod 750 ./gradlew
./gradlew clean
./gradlew build --no-daemon --refresh-dependencies

docker stop backend
docker rm backend
docker rmi backend:1.0.0
docker build -t backend:1.0.0 .

docker run -itd \
  --restart always \
  --name backend \
  -p 8080:8080 \
  -v /srv/img:/srv/img \
  backend:1.0.0
