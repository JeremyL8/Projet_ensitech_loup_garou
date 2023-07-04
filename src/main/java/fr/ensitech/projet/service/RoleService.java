package fr.ensitech.projet.service;

import fr.ensitech.projet.entity.Role;
import fr.ensitech.projet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
