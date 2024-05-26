package com.project;

import com.project.configuration.MyConfiguration;
import com.project.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);

        IUserService userService = context.getBean("userServiceBean", IUserService.class);

       /* User user = new User("Pavel", "Martynuik", 30);
        User user1 = new User("Maria", "Popova", 25);
        User user2 = new User("Grizha", "Lolipop", 22);
        User user3 = new User("Lena", "Golozha", 26);
        User user4 = new User("Tatiana", "Kozlova", 27);
        User user5 = new User("Nikita", "Franov", 35);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        userList.forEach(userService::saveUser);

        //Получаем всех рользователей до изменений
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        System.out.println("===========================");

        User userFromBd = userService.getUserById(3);

        userFromBd.setSurname("Kozlow");

        userService.updateUser(userFromBd);*/

        try {
            User user = userService.getUserById(100);
            System.out.println(user);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
