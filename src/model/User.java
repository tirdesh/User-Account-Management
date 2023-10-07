/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;

public class User {
    private String nuId;
    private String username;
    private final ArrayList<String> passwordHashes = new ArrayList<>();
    private boolean enabled;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNuId() {
        return nuId;
    }

    public void setNuId(String nuId) {
        this.nuId = nuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean checkPassword(String password) {
        if (!passwordHashes.isEmpty()) {
            String latestPasswordHash = passwordHashes.get(0);
            return BCrypt.checkpw(password, latestPasswordHash);
        }
        return false;
    }

    public boolean updatePassword(String newPassword) {
        if (newPassword == null || newPassword == "" || newPassword == " "){
            return true;
        }
        // Hash the new password using BCrypt
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        
        // Check if the new hashed password is not the same as any of the existing hashes
        for (String storedPasswordHash : passwordHashes) {
            if (BCrypt.checkpw(newPassword, storedPasswordHash)) {
                // New password matches an old one, so it cannot be used
                return false;
            }
        }
        
        // Add the new hashed password at the beginning of the list (index 0)
        passwordHashes.add(0, hashedPassword);
        return true; // Password updated successfully
    }
}
