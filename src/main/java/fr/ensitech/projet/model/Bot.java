package fr.ensitech.projet.model;

import fr.ensitech.projet.entity.Role;

public class Bot {

    private String name;
    private Role role;


    public Bot(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
