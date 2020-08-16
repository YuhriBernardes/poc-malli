FROM clojure:openjdk-8-tools-deps-slim-buster as build

WORKDIR /build

COPY ./src ./src
COPY ./deps.edn ./

RUN clojure -Spom

RUN clojure -A:uberjar

FROM openjdk:8-slim

WORKDIR /app

COPY --from=build /build/target/poc_malli.jar ./

CMD java -jar poc_malli.jar
