package com.psira.service;

import com.psira.model.User;
import com.psira.pojo.AuthUser;
import com.psira.repository.UserRepository;
import com.psira.utils.SendMail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    KafkaProducer kafkaProducer;

    @Inject
    EmailService emailService;

    public List<User> listAll() {
        return userRepository.listAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(User user) {
        userRepository.persist(user);
        AuthUser authUser = new AuthUser();
        authUser.setCreatedAt(LocalDateTime.now());
        authUser.setUpdatedAt(LocalDateTime.now());
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setRole("APPLICANT");
        authUser.setEmail(user.getUsername());

        kafkaProducer.sendMessage(authUser);
        new SimpleProducer().produce(authUser);

        SendMail sendMail = new SendMail();
        sendMail.sendMail(user.getUsername(), "Welcome to PSiRA e-Recruitment Platform",
                "Welcome to , " + user.getName() + " " + user.getSurname());
        emailService.sendEmail(user.getUsername(), "Welcome to our platform",
                "Welcome to our platform, " + user.getName() + " " + user.getSurname());

        return user;
    }

    public User update(User user) {
        return userRepository.merge(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
