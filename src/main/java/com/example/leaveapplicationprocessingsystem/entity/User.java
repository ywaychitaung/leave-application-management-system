package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String email;

    private String username;
    private String password;
    private Integer roleId;
    // added Role into User
    private ApplicationConstants.UserRole role;
    public User() {
    }

    public User(String email,
                String username,
                String password,
                Integer roleId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getRoleId() { return roleId; }

    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public ApplicationConstants.UserRole getRole() {
        return role;
    }

    public void setRole(ApplicationConstants.UserRole role) {
        this.role = role;
    }
}
