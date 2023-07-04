package fr.ensitech.projet.controller;

import fr.ensitech.projet.entity.*;
import fr.ensitech.projet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class WebAppController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;


    @GetMapping("/*")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/game")
    public String game(){
        return "game";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String role(Model model){
        model.addAttribute("roles",roleService.getAllRole());
        model.addAttribute("newRole", new Role());
        return "admin/role";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin")
    public String viewAdminCreateRole(@ModelAttribute Role newRole, @RequestParam("image") File image) {
        newRole.setUrlPicture(image.getPath());
        newRole.setCanDelete(1);
        this.roleService.createOrModify(newRole);
        return "redirect:admin";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/delete")
    public String deleteRole(@RequestParam("id") Long id){
        this.roleService.deleteRoleWithId(Math.toIntExact(id));
        return "redirect:/admin";
    }


}
