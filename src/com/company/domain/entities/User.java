package com.company.domain.entities;

import com.company.domain.enuns.Role;

public class User {

    private String password;
    private String email;
    private Role role;

    public User() {
        this.password = new String();
        this.email = new String();
        this.role = Role.NONE;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
        this.role = Role.NONE;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role newRole) {
        this.role = newRole;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
