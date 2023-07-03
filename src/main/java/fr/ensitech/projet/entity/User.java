package fr.ensitech.projet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String username;

    @Column(name = "pwd")
    private String password;

    private String levels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
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

    public User(int id, String userName, String pwd, String levels) {
        this.id = id;
        this.username = userName;
        this.password = pwd;
        this.levels = levels;
    }


    public User(String userName, String pwd, String levels) {
        this.username = userName;
        this.password = pwd;
        this.levels = levels;
    }

    public User() {
    }
}
