package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.apachecommons.CommonsLog;
import org.example.app.GreetingServiceImpl;

import java.io.IOException;

@CommonsLog
public class ServerImpl {

    public static void main(String[] args) throws IOException, InterruptedException {

        final Server server = ServerBuilder.forPort(8070)
            .addService(new GreetingServiceImpl())
            .build();

        server.start();

        log.info("Server started");

        server.awaitTermination();
    }
}
