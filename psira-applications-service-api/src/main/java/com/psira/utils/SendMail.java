package com.psira.utils;

import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendMail {

    public static void main(String[] args) {}

    public void sendMail(String to, String subject, String body) {

        // Sender's email ID
        String from = "sam.rabophala@gmail.com";
        // SMTP server for Gmail
        String host = "smtp.gmail.com";

        // Set properties for the mail server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object with authentication details
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sam.rabophala@gmail.com", "krthhloicihnprhi");
            }
        });

        session.setDebug(true);  // Used to debug SMTP issues

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From, To, and Subject fields
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            // Set the content of the email
            message.setContent("<h1>" + body + "</h1>", "text/html");

            System.out.println("Sending...");
            // Send the message
            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
