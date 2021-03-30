FROM maven:alpine AS development
WORKDIR /gatling
COPY . .

FROM development AS build
RUN mvn clean compile

FROM maven:alpine AS release
COPY --from=build /root/.m2/repository /root/.m2/repository
COPY --from=build /gatling /gatling
WORKDIR /gatling
