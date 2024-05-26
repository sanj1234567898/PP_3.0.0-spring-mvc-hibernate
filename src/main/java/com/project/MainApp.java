package com.project;

import com.project.configuration.MyConfiguration;
import com.project.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.models.User;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);

        IUserService userService = context.getBean("userServiceBean", IUserService.class);

        User user = new User("Pavel", "Martynuik", 30);



        //userService.saveUser(user);

        userService.deleteUser(user);

        /*List<User> userList =
                userService.getAllUsers();

        userList.forEach(System.out::println);*/

    }
}
