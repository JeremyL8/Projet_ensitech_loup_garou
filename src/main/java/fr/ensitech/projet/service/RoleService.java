package fr.ensitech.projet.service;

import fr.ensitech.projet.entity.Role;
import fr.ensitech.projet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    /**
     * Allow to recover all role
     * @return list with role
     */
    public Iterable<Role> getAllRole(){
        return this.roleRepository.findAll();
    }


    /**
     * Allow to add or modify a role
     * @param newRole the role who want to add or modify
     */
    public void createOrModify(Role newRole) {
        this.roleRepository.save(newRole);
    }

    /**
     * Allow to delete a role with his id
     * @param id the if of the role who want to delete
     */
    public void deleteRoleWithId(int id) {
        this.roleRepository.deleteById(id);
    }

    /**
     * Allow to recover a random role werewolf
     * @return the random role werewolf
     */
    public Role getWereWolf() {
        Random random = new Random();
        List<Role> allWolfRole = this.roleRepository.getAllWolfRole();
        int index = random.nextInt(allWolfRole.size());
        return allWolfRole.get(index);
    }

    /**
     * Allow to recover a random role villager
     * @return the random role villager
     */
    public Role getRandomVillager() {
        Random random = new Random();
        List<Role> allVillagerRole = this.roleRepository.getAllVillagerRole();
        int index = random.nextInt(allVillagerRole.size());
        return allVillagerRole.get(index);
    }

    /**
     * Allow to recover the clairvoyant role
     * @return the role clairvoyant
     */
    public Role getClairvoyant() {
        Optional<Role> temp =  this.roleRepository.findById(2);
        if (temp.isPresent())
            return temp.get();
        return null;
    }

    /**
     * Allow to recover the thief role
     * @return the role thief
     */
    public Role getRoleThief() {
        Optional<Role> temp =  this.roleRepository.findById(4);
        if (temp.isPresent())
            return temp.get();
        return null;
    }

    /**
     * Allow to recover the simple villager role
     * @return the role simple villager
     */
    public Role SimpleVillager() {
        Optional<Role> temp =  this.roleRepository.findById(3);
        if (temp.isPresent())
            return temp.get();
        return null;
    }
}
