package fr.ensitech.projet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "descript")
    private String description;

    @Column(name = "picture")
    private String urlPicture;

    @Column(name = "can_delete")
    private int canDelete;

    @Column(name = "wolf")
    private int isWolf;

    @Column(name = "villager")
    private int isVillager;

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

    public int getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(int canDelete) {
        this.canDelete = canDelete;
    }

    public int getIsWolf() {
        return isWolf;
    }

    public void setIsWolf(int isWolf) {
        this.isWolf = isWolf;
    }

    public int getIsVillager() {
        return isVillager;
    }

    public void setIsVillager(int isVillager) {
        this.isVillager = isVillager;
    }

    public Role() {
    }

    public Role(int id, String name, String description, String urlPicture, int canDelete, int isWolf, int isVillager){
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
        this.canDelete = canDelete;
        this.isWolf = isWolf;
        this.isVillager = isVillager;
    }

    public Role(String name, String description, String urlPicture, int canDelete, int isWolf, int isVillager) {
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
        this.canDelete = canDelete;
        this.isWolf = isWolf;
        this.isVillager = isVillager;
    }
}
