FROM node:12-alpine as app
WORKDIR /usr/src/app
COPY ./app/package.json ./
COPY ./app/yarn.lock ./
RUN yarn install --frozen-lockfile
COPY ./app/ .
RUN yarn run build

FROM maven:3.8.1-openjdk-16 AS build
COPY ./server/src /usr/src/app/src
COPY ./server/pom.xml /usr/src/app
COPY --from=app /usr/src/app/build /usr/src/app/src/main/resources/static
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:16-jdk-alpine
COPY --from=build /usr/src/app/target/Zooplus-0.0.1-SNAPSHOT.jar /usr/app/Zooplus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/Zooplus.jar"]