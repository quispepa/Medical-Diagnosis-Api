package org.example.medicaldiagnosisapi.controllers;


import org.example.medicaldiagnosisapi.models.User;
import org.example.medicaldiagnosisapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API for User management
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * User service for accessing user data
     */
    @Autowired
    private UserService userService;

    /**
     * Get a list of all users
     *
     * @return list of all users
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {

        System.out.println(getLoggedInUsername());

        return userService.getUsers();
    }

    /**
     * Save a new user
     *
     * @param user the user to be saved
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }


    public String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername(); // Returns the username
            } else {
                return principal.toString(); // If it's a string (like when using JWT or OAuth2)
            }
        }
        return null; // Not authenticated
    }
}
