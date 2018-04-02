package ru.tsystems.javaschool.goldenguide.service;

import ru.tsystems.javaschool.goldenguide.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User find(String login);
    void save(User user);
    void changePassword(User user);
    void delete(String login);
}
