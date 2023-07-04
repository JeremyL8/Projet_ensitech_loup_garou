package fr.ensitech.projet.repository;

import fr.ensitech.projet.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query(value = "SELECT * FROM role WHERE wolf = 1 " ,nativeQuery = true)
    List<Role> getAllWolfRole();

    @Query(value = "SELECT * FROM role WHERE villager = 1", nativeQuery = true)
    List<Role> getAllVillagerRole();

}
