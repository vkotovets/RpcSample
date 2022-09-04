package org.example.app;

import io.grpc.stub.StreamObserver;
import org.example.grpc.GreetingServiceGrpc;
import org.example.grpc.GreetingServiceOuterClass;

import static java.lang.String.format;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(
        final GreetingServiceOuterClass.GreetingRequest request,
        final StreamObserver<GreetingServiceOuterClass.GreetingResponse> responseObserver
    ) {

        for(int i = 0; i < 10000; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final GreetingServiceOuterClass.GreetingResponse response = GreetingServiceOuterClass
                .GreetingResponse.newBuilder()
                .setGreeting(format("Hello from server, %s", request.getName()))
                .build();

            responseObserver.onNext(response);
        }


        responseObserver.onCompleted();
    }
}
