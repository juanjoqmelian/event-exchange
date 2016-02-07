FROM maven:latest
MAINTAINER Juan Quintana <juan.quintana@luxuriem.com>
ADD . /build/event-exchange
WORKDIR /build/event-exchange
RUN mvn clean package -U
WORKDIR ./target
CMD java -jar event-exchange-1.0-SNAPSHOT.jar