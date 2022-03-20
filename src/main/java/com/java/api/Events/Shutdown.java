package com.java.api.Events;

import com.java.api.Services.MongoService;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.ShutdownEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class Shutdown implements ApplicationEventListener<ShutdownEvent> {

    @Inject
    private MongoService mongoService;

    @Override
    public void onApplicationEvent(ShutdownEvent event) {
        System.out.println("Shutdown initiated");
        System.out.println("Closing database connections");

        mongoService.closeClientConnection();

        System.out.println("Shutdown complete");
    }

}
