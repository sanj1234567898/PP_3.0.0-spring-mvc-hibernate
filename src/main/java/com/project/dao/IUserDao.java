package com.project.dao;

import com.project.models.User;

import java.util.List;

public interface IUserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    void updateUser(User user);

}
