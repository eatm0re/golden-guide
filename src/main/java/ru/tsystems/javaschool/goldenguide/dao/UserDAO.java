package ru.tsystems.javaschool.goldenguide.dao;

import ru.tsystems.javaschool.goldenguide.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(long id);
    User findByLogin(String login);
    boolean isExists(String login);
    void save(User user);
    boolean updatePasswordById(User user);
    boolean updatePasswordByLogin(User user);
    boolean deleteById(long id);
    boolean deleteByLogin(String login);
}
