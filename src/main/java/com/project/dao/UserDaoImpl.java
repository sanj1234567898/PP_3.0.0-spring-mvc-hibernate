package com.project.dao;

import com.project.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();

        if (!userList.isEmpty()) {
            return userList;
        } else {
            throw new RuntimeException("На данный момент пользователей в базе нет");
        }
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);

        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Данного пользователя не существует");
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
