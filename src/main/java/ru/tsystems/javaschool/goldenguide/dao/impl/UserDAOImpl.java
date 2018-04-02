package ru.tsystems.javaschool.goldenguide.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.goldenguide.dao.UserDAO;
import ru.tsystems.javaschool.goldenguide.entity.User;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public User findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByLogin(String login) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User user where user.login = ?1")
                .setParameter(1, login)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean isExists(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("select user.login from User user where user.login = ?1")
                .setParameter(1, login)
                .stream()
                .anyMatch(user -> true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(User user) {
        sessionFactory.getCurrentSession()
                .persist(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean updatePasswordById(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("update User user set user.password = ?1 where user.id = ?2")
                .setParameter(1, user.getPassword())
                .setParameter(2, user.getId())
                .executeUpdate() > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean updatePasswordByLogin(User user) {
        return sessionFactory.getCurrentSession()
                .createQuery("update User user set user.password = ?1 where user.login = ?2")
                .setParameter(1, user.getPassword())
                .setParameter(2, user.getLogin())
                .executeUpdate() > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean deleteById(long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete User user where user.id = ?1")
                .setParameter(1, id)
                .executeUpdate() > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean deleteByLogin(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete User user where user.login = ?1")
                .setParameter(1, login)
                .executeUpdate() > 0;
    }
}
