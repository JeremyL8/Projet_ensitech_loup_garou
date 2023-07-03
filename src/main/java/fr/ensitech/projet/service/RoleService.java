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


}
