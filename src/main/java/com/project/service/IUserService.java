package com.project.service;

import com.project.models.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    void updateUser(User user);
}
