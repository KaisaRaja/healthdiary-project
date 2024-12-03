package org.example.fevermonitorproject.service;

import org.example.fevermonitorproject.controller.UserController;
import org.example.fevermonitorproject.model.User;
import org.example.fevermonitorproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean login(String username, String password) {
        // Replace this with actual database logic
        return "user".equals(username) && "password".equals(password);
        // return users.containsKey(username) && users.get(username).equals(password);
    }


    public boolean register(User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            System.out.println("Username is already taken. Please try again!");
            return false; // Registration failed
        }

        // Save the new user to the database
        userRepository.save(user);
        System.out.println("User registered successfully: " + user.getUsername());
        return true; // Registration successful
    }

    public String getUserByName(String username) {
        return "Tere, " + username;

    }

    public String addUser(User user) {
        // userRepository.save(user);
        // users.add(user);
        printUsers();
        System.out.println("User with ID " + user.getFirstName() + " has been added");
        return "User " + user.getFirstName() + " has been added successfully";
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        return userRepository.findAll();
        // TODO !
        // Pane sinna userrepository
    }

    public String updateUser(Long id, User user) {
        userRepository.save(user);
        for (User existingUser : getAllUsers()) {
            if (existingUser.getId().equals(id)) {
                existingUser.setFirstName(user.getFirstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setEmail(user.getEmail());
                System.out.println("E-mail updated with: " + existingUser.getEmail());
                return "User with ID " + id + " has been updated.";
            }

        }
        return "User with ID " + id + " was not found";
    }

    public String deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        for (User user : getAllUsers())
            if (user.getId().equals(userId)) {
                getAllUsers().remove(userId);
                System.out.println("User with ID " + userId + " deleted.");
            }
        System.out.println("New user list is:" + getAllUsers());
        return "User with ID " + userId + " was not found";

    }
    public User getUserById(String id) {
        getAllUsers();
        for (User user : getAllUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        } return null;


    }

    public String getUserById(int userId) {
        return "User ID: " + userId;
    }

    public String getFullName(String firstName, String lastName) {
        return "Full name is: " + firstName + " " + lastName;
    }
public void printUsers(){
    System.out.println(getAllUsers());
}

}