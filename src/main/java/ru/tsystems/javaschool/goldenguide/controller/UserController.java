package ru.tsystems.javaschool.goldenguide.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.goldenguide.entity.User;

import java.util.List;

public interface UserController {
    ResponseEntity<List<User>> findAll();
    ResponseEntity<User> find(String login);
    ResponseEntity<Void> save(User user);
    ResponseEntity<Void> changePassword(User user);
    ResponseEntity<Void> delete(String login);
}
