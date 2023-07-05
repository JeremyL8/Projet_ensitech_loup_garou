package fr.ensitech.projet.model;

import fr.ensitech.projet.entity.*;
import fr.ensitech.projet.service.RoleService;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Player player;
    private final int nbPlayer;

    private ArrayList<Bot> othersPlayer;
    private ArrayList<Role> listRoles;

    private final RoleService roleService;

    public ArrayList<Role> getListRoles() {
        return listRoles;
    }

    public void setListRoles(ArrayList<Role> listRoles) {
        this.listRoles = listRoles;
    }

    public ArrayList<Bot> getOthersPlayer() {
        return othersPlayer;
    }

    public void setOthersPlayer(ArrayList<Bot> othersPlayer) {
        this.othersPlayer = othersPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game(Player player, int nb, RoleService roleService){
        this.player = player;
        this.nbPlayer = nb;
        this.othersPlayer = new ArrayList<>();
        this.listRoles = new ArrayList<>();
        this.roleService = roleService;
    }

    /**
     * Allow to generate random list of role
     */
    private void generateRoleList(){
        int nbWolf;
        int nbVillager;
        this.listRoles.add(getClairvoyant());
        if (this.nbPlayer >= 8 && this.nbPlayer <=11 )
            nbWolf = 2;
        else
            nbWolf = 3;
        nbVillager = this.nbPlayer - nbWolf - 1;
        for (int i = 0; i < nbWolf; i++) {
            this.listRoles.add(getRandomWolf());
        }
        for (int i = 0; i < nbVillager; i++) {
            this.listRoles.add(getRandomVillager());
        }
    }

    /**
     * Allow to recover a random wolf
     * @return a random wolf role
     */
    private Role getRandomWolf() {
        return this.roleService.getWereWolf();
    }

    /**
     * Allow to recover the clairvoyant
     * @return an clairvoyant role
     */
    private Role getClairvoyant() {
        return this.roleService.getClairvoyant();
    }

    /**
     * Allow to recover a random villager
     * @return a random villager role
     */
    private Role getRandomVillager() {
        Role tmp = this.roleService.getRandomVillager();
        while (this.listRoles.contains(tmp) && tmp.getId() != 3){
            tmp = this.roleService.getRandomVillager();
        }
        return tmp;
    }

    /**
     * Allow to set up the role of the different players
     */
    private void generateSetRolePlayers(){
        Random random = new Random();
        int index_player = random.nextInt(this.listRoles.size());
        this.player.setRole(this.listRoles.get(index_player));
        this.listRoles.remove(index_player);
        for (int i = 1; i < this.nbPlayer ; i++) {
            int index = random.nextInt(this.listRoles.size());
            Bot bot = new Bot("bot" + i, this.listRoles.get(index));
            this.othersPlayer.add(bot);
            this.listRoles.remove(index);
        }
    }

    /**
     * Allow to initialize the game
     */
    private void gameInitialization(){
        this.generateRoleList();
        this.hadThief();
        this.generateSetRolePlayers();
        System.out.println(player.getRole().getName());
        for (Bot bot : this.othersPlayer) {
            System.out.println(bot.getName() + " " + bot.getRole().getName());
        }
        System.out.println("reste");
        for (Role role: this.listRoles)
            System.out.println(role.getName());
    }

    private void hadThief() {
        Role thief = this.roleService.getRoleThief();
        if (this.listRoles.contains(thief)){
            Role simple = this.roleService.SimpleVillager();
            this.listRoles.add(simple);
            this.listRoles.add(simple);
        }
    }

    public void runGame(){
        this.gameInitialization();
    }

}
