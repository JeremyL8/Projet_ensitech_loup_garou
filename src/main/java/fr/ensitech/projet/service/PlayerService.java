package fr.ensitech.projet.service;

import fr.ensitech.projet.entity.Player;
import fr.ensitech.projet.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Allow to create or modify a player
     * @param player the player who want to add or edit
     */
    public void createOrEditPlayer(Player player){
        this.playerRepository.save(player);
    }

    /**
     * Allow to recover a specific player with hid id
     * @param id the id of the player
     * @return the specific player
     */
    public Optional<Player> getPlayerById(int id){
        return this.playerRepository.findById(id);
    }

}
