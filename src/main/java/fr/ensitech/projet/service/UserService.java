package fr.ensitech.projet.service;

import fr.ensitech.projet.entity.User;
import fr.ensitech.projet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Allow to create or modify a user
     * @param user the user who want to add or edit
     */
    public void createOrModifyUser(User user){
        this.userRepository.save(user);
    }


}
