package com.ivoyant.model;

import javax.persistence.*;

@Entity
@Table(name="user" ,uniqueConstraints = @UniqueConstraint(columnNames = "username"))

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name ="fullName")
    private String fullName;
    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    public User() {

    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }
}
