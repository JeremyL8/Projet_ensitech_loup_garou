package fr.ensitech.projet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "pwd")
    private String password;

    @Column(name = "permission")
    private String role;

    private String levels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return password;
    }

    public void setPwd(String pwd) {
        this.password = pwd;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String userName, String pwd, String levels, String role) {
        this.id = id;
        this.username = userName;
        this.password = pwd;
        this.levels = levels;
        this.role = role;
    }


    public User(String userName, String pwd, String levels, String role) {
        this.username = userName;
        this.password = pwd;
        this.levels = levels;
        this.role = role;
    }

    public User() {
    }
}
