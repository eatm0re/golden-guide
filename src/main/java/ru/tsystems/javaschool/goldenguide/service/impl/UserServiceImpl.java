package ru.tsystems.javaschool.goldenguide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.goldenguide.dao.UserDAO;
import ru.tsystems.javaschool.goldenguide.entity.User;
import ru.tsystems.javaschool.goldenguide.service.UserService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public User find(String login) {
        User user = userDAO.findByLogin(login);
        if (user == null) {
            throw new EntityNotFoundException("User " + login + " not found");
        }
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(User user) {
        if (userDAO.isExists(user.getLogin())) {
            throw new EntityExistsException("User " + user.getLogin() + " is already exists");
        }
        userDAO.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void changePassword(User user) {
        if (!userDAO.updatePasswordByLogin(user)) {
            throw new EntityNotFoundException("User " + user.getLogin() + " not found");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void delete(String login) {
        if (!userDAO.deleteByLogin(login)) {
            throw new EntityNotFoundException("User " + login + " not found");
        }
    }
}
