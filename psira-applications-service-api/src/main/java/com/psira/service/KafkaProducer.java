package com.psira.service;

import com.psira.pojo.AuthUser;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class KafkaProducer {
    @Inject
    @Channel("generated-user-logins")
    Emitter<AuthUser> emitter;

    public void sendMessage(AuthUser authUser) {
        emitter.send(authUser);
    }
}
