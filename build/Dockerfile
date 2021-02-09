FROM openjdk:8-jdk

ENV VERTICLE_FILE prebid-cache.jar

# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles

#EXPOSE 5000

# Copy your fat jar to the container
COPY ./target/$VERTICLE_FILE $VERTICLE_HOME/

RUN mkdir -p /var/log/mbid-cache/

# Launch the verticle
WORKDIR $VERTICLE_HOME

# Add Tini
ENV TINI_VERSION v0.18.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini-static /tini
RUN chmod +x /tini

ENTRYPOINT ["/tini", "--"]


CMD ["exec java -server -Duser.timezone=UTC -Xms4096m -Xmx4096m -Dcom.sun.management.jmxremote -Dsun.management.jmxremote.level=FINEST -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.port=8000 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.rmi.port=8000 -Djava.rmi.server.hostname=127.0.0.1 -Djava.rmi.server.hostname=127.0.0.1 -XX:+PrintFlagsFinal  -XX:+UnlockDiagnosticVMOptions -Dserver.port=8080 -Dspring.profiles.active=prod -Dmanagement.endpoint.info.enabled=false -Dspring.redis.host=redishost -Dcors.enabled=true -jar $VERTICLE_FILE"]