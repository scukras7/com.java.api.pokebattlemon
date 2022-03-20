package com.java.api.Entities;

public class User {

    private String email;
    private Boolean active;

    public User () {}

    public User (String email, Boolean active) {
        this.email = email;
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}
