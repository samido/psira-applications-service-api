package com.psira.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmailService {

    @Inject
    Mailer mailer;

    public void sendEmail(String recipient, String subject, String body) {
        mailer.send(
                Mail.withText(recipient, subject, body)
        );
    }
}

