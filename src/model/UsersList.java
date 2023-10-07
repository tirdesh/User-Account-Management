/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Gautam16
 */
public class UsersList {
    private ArrayList<User> ulist;
    private User currentUser; // Store the current user here

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public UsersList() {
        this.ulist = new ArrayList<User>();
        User admin = this.addNewUser();
        admin.setNuId(null);
        admin.setEnabled(true);
        admin.setUsername("admin");
        admin.updatePassword("admin");
    }

    // Add a new user to the database
    public User addNewUser(){
        User udeets = new User();
        ulist.add(udeets);
        return udeets;
    }
    

    // Retrieve a user by username
    public User getUserByUsername(String Username) {
        for (User user : ulist) {
            if (user.getUsername().equals(Username)) {
                return user;
            }
        }
        return null; // User not found
    }

    public User getUserByNUID(String NUID) {
        for (User user : ulist) {
            String userNUID = user.getNuId();
            if (userNUID != null && userNUID.equals(NUID)) {
                return user;
            }
        }
        return null; // User not found
    }
    
    public void printAllUsers() {
    System.out.println("List of Users:");
    for (User user : ulist) {
        System.out.println("NUID: " + user.getNuId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Enabled: " + user.isEnabled());
        System.out.println();
    }
}


}


