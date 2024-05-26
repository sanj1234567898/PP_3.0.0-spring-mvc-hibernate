package com.project.dao;

import com.project.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();

        if (!userList.isEmpty()) {
            return userList;
        } else {
            throw new RuntimeException("На данный момент пользователей в базе нет");
        }
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }

    @Override
    public User getUserById(long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);

        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Данного пользователя не существует");
        }
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }
}
