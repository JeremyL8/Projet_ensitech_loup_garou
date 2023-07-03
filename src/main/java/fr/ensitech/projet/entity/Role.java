package fr.ensitech.projet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleName")
    private String name;

    @Column(name = "descript")
    private String description;

    @Column(name = "picture")
    private String urlPicture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public Role() {
    }

    public Role(int id, String name, String description, String urlPicture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
    }

    public Role(String name, String description, String urlPicture) {
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
    }
}
